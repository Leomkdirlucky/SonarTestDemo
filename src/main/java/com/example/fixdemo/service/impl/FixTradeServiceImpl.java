package com.example.fixdemo.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.fixdemo.dao.*;
import com.example.fixdemo.entity.*;
import com.example.fixdemo.service.FixTradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laoyj
 * @since 2022-11-09 09:45:38
 */
@Service
public class FixTradeServiceImpl implements FixTradeService {
    @Resource
    private CarOrderDetailDao orderDetailDao;

    @Resource
    private FixTradeDao fixTradeDao;

    @Resource
    private CarOrderGoodsDiscountDao goodsDiscountDao;

    @Resource
    private CarMixPayorderDao mixPayorderDao;

    @Resource
    private CarOrderDao carOrderDao;

    @Resource
    private CarShoporderDetailDao shoporderDetailDao;

    @Resource
    private CarOrderDiscountDao orderDiscountDao;

    @Resource
    private CarShoporderDao shoporderDao;

    int totalMoneyChange = 0;
    int totalFeeChange = 0;
    int discountChange = 0;
    int shiftId = 0;
    Map<String, JSONObject> payChannelChange = new HashMap<>();

    int currentStation = 0;

    @Override
    public boolean fixWrongTrade(List<String> tradeNoList) {
        try {
            for (String tradeNo : tradeNoList) {
                int stationId = getStationIdFromTradeNo(tradeNo);
                if (currentStation == 0) {
                    currentStation = stationId;
                }
                if ((stationId != 0 && stationId != currentStation)) {
                    // 当前油站的记录已经处理完，需要汇总班次的数据
                    sumShiftCountData(stationId);
                }
                fixWrongTradeHandle(stationId, tradeNo);
                if (tradeNoList.indexOf(tradeNo) == tradeNoList.size() - 1) {
                    // 列表的最后一条记录，需要汇总班次的数据
                    sumShiftCountData(stationId);
                }
            }
            return true;
        } finally {
            clearCache();
            currentStation = 0;
        }
    }

    private void fixWrongTradeHandle(int stationId, String tradeNo) {
        List<JSONObject> fixShopOrderDetailList = new ArrayList<>();

        // 查询成功的便利店订单
        CarOrderDetail orderDetail = new LambdaQueryChainWrapper<>(orderDetailDao)
                .eq(CarOrderDetail::getTradeNo, tradeNo).eq(CarOrderDetail::getOrderType, 2)
                .eq(CarOrderDetail::getTradeState, 5).eq(CarOrderDetail::getValid, 1).last("limit 1").one();

        // 查询是否有油品订单
        CarOrderDetail oilOrderDetail = new LambdaQueryChainWrapper<>(orderDetailDao)
                .eq(CarOrderDetail::getTradeNo, tradeNo).eq(CarOrderDetail::getOrderType, 1)
                .eq(CarOrderDetail::getTradeState, 5).eq(CarOrderDetail::getValid, 1).last("limit 1").one();
        System.out.println("\r\n");
        System.out.println("--tradeNo:" + tradeNo);

        // 支付工具
        CarMixPayorder mixPayorder = new LambdaQueryChainWrapper<>(mixPayorderDao)
                .eq(CarMixPayorder::getTradeNo, tradeNo).last("limit 1").one();
        shiftId = mixPayorder.getShiftId();

        // 交易总表
        CarOrder carOrder = new LambdaQueryChainWrapper<>(carOrderDao).eq(CarOrder::getTradeNo, tradeNo)
                .eq(CarOrder::getValid, 1).last("limit 1").one();

        // 便利店基础优惠
        List<CarOrderGoodsDiscount> goodsDiscountList = new LambdaQueryChainWrapper<>(goodsDiscountDao)
                .eq(CarOrderGoodsDiscount::getOrderNo, orderDetail.getOrderNo())
                .eq(CarOrderGoodsDiscount::getClasstype, 1).eq(CarOrderGoodsDiscount::getValid, 1).list();

        // 便利店总原金额、便利店总优惠、累计组合商品优惠
        int shopTotalPrice = 0, shopDiscountFee = 0, groupGoodsDiscount = 0;
        List<JSONObject> shopOrderDetailList = fixTradeDao.queryShopOrderDetail(stationId, tradeNo);
        //List<JSONObject> subGoodsList = fixTradeDao.queryOrderSubGoodsPrice(tradeNo);
        List<String> parentGoodList = new ArrayList<>();  // 已经计算完金额的父商品列表
        for (JSONObject shopOrderDetail : shopOrderDetailList) {

            if (shopOrderDetail.get("sub_good_code") != null) {
                if (parentGoodList.contains(shopOrderDetail.getStr("parent_code"))) {
                    continue;
                }
                // 父商品售价 * 购买数量
                int fixTotalFee = shopOrderDetail.getInt("good_count") * shopOrderDetail.getInt("sell_price");
                int fixTotalMoney = 0;
                List<JSONObject> subGoodsList = fixTradeDao.queryGroupGoodsList(stationId, tradeNo, shopOrderDetail.getStr("good_id"));
                for (JSONObject subGoods : subGoodsList) {
                    // 倍数关系 * 子商品售价
                    fixTotalMoney += subGoods.getInt("unit_times") * subGoods.getInt("sell_price");
                }
                //for (JSONObject subGoods : subGoodsList) {
                //    if (shopOrderDetail.getStr("parent_code").equals(subGoods.getStr("parent_code"))) {
                //        // 倍数关系 * 子商品售价
                //        fixTotalMoney += shopOrderDetail.getInt("unit_times") * subGoods.getInt("sell_price");
                //    }
                //}
                // 子商品售价 * 数量
                fixTotalMoney = fixTotalMoney * shopOrderDetail.getInt("good_count");
                // 当前商品的组合优惠
                int tempGroupDiscount = fixTotalMoney - fixTotalFee;
                shopOrderDetail.putOpt("groupDiscount", tempGroupDiscount);
                // 累计商品的组合优惠
                groupGoodsDiscount += tempGroupDiscount;
                for (CarOrderGoodsDiscount goodsDiscount : goodsDiscountList) {
                    if (goodsDiscount.getGoodCode().equals(shopOrderDetail.getStr("parent_code"))) {
                        // 减去基础优惠
                        fixTotalFee -= goodsDiscount.getDiscountFee();
                        break;
                    }
                }
                shopOrderDetail.putOpt("fixTotalMoney", fixTotalMoney);
                // 减去线上优惠
                shopOrderDetail.putOpt("fixTotalFee", fixTotalFee - shopOrderDetail.getInt("online_discount_fee"));
                // 组合优惠+线上优惠，其实如果有其他线下优惠，这里也要加上
                shopOrderDetail.putOpt("fixDiscountFee", tempGroupDiscount + shopOrderDetail.getInt("online_discount_fee"));
                shopOrderDetail.putOpt("fixOffLineDiscountFee", tempGroupDiscount);
                shopTotalPrice += fixTotalMoney;
                shopDiscountFee += shopOrderDetail.getInt("fixDiscountFee");
                parentGoodList.add(shopOrderDetail.getStr("parent_code"));
                fixShopOrderDetailList.add(shopOrderDetail);
            } else {
                shopTotalPrice += shopOrderDetail.getInt("total_money");
                shopDiscountFee += shopOrderDetail.getInt("discount_fee");
            }
        }
        int shopTotalFee = shopTotalPrice - shopDiscountFee;

        int totalMoney = shopTotalPrice, discountFee = shopDiscountFee, totalFee = shopTotalFee, oilOffLineDiscountFee = 0;
        if (oilOrderDetail != null) {
            totalMoney += oilOrderDetail.getTotalMoney();
            discountFee += oilOrderDetail.getDiscountFee();
            totalFee += oilOrderDetail.getTotalFee();
            oilOffLineDiscountFee += oilOrderDetail.getOfflineDiscountFee();
        }
        if (mixPayorder.getTotalFee() != totalFee) {
            // 这次bug中支付表的金额没有维护错
            System.out.println(StrUtil.format("!!!!!支付表支付金额：{}，修复实付金额：{}", mixPayorder.getTotalFee(), totalFee));
        }

        int shopOffLineDiscountFee = 0;
        for (JSONObject fixShopOrderDetail : fixShopOrderDetailList) {
            CarShoporderDetail shoporderDetail = new LambdaQueryChainWrapper<>(shoporderDetailDao)
                    .eq(CarShoporderDetail::getOrderNo, orderDetail.getOrderNo())
                    .eq(CarShoporderDetail::getGoodId, fixShopOrderDetail.getStr("good_id"))
                    .last("limit 1").one();
            String sql = StrUtil.format("UPDATE car_shoporder_detail SET total_money = total_money - {}, discount_fee = discount_fee - {}, offline_discount_fee = offline_discount_fee - {}, total_fee = total_fee - {}, update_datetime = NOW() WHERE order_no = '{}' AND good_id = '{}';"
                    , shoporderDetail.getTotalMoney() - fixShopOrderDetail.getInt("fixTotalMoney")
                    , shoporderDetail.getDiscountFee() - fixShopOrderDetail.getInt("fixDiscountFee")
                    , shoporderDetail.getOfflineDiscountFee() - fixShopOrderDetail.getInt("fixOffLineDiscountFee")
                    , shoporderDetail.getTotalFee() - fixShopOrderDetail.getInt("fixTotalFee")
                    , orderDetail.getOrderNo(), fixShopOrderDetail.getStr("good_id"));
            //String sql = StrUtil.format("UPDATE car_shoporder_detail SET total_money = {}, discount_fee = {}, offline_discount_fee = {}, total_fee = {}, update_datetime = NOW() WHERE order_no = '{}' AND good_id = '{}';"
            //        , fixShopOrderDetail.getInt("fixTotalMoney"), fixShopOrderDetail.getInt("fixDiscountFee")
            //        , fixShopOrderDetail.getInt("fixOffLineDiscountFee"), fixShopOrderDetail.getInt("fixTotalFee")
            //        , orderDetail.getOrderNo(), fixShopOrderDetail.getStr("good_id"));
            System.out.println(sql);

            if (fixShopOrderDetail.get("sub_good_code") != null) {
                // ordertype2便利店 classtype6组合商品 valid1有效
                CarOrderGoodsDiscount goodsDiscount = new LambdaQueryChainWrapper<>(goodsDiscountDao)
                        .eq(CarOrderGoodsDiscount::getTradeNo, orderDetail.getTradeNo())
                        .eq(CarOrderGoodsDiscount::getOrderNo, orderDetail.getOrderNo())
                        .eq(CarOrderGoodsDiscount::getOrderType, 2).eq(CarOrderGoodsDiscount::getClasstype, 6)
                        .eq(CarOrderGoodsDiscount::getValid, 1).last("limit 1").one();
                String discountSql = StrUtil.format("UPDATE car_order_goods_discount SET discount_fee = discount_fee - {}, update_datetime = NOW() WHERE trade_no = '{}' AND order_no = '{}' AND order_type = 2 AND good_code = '{}' AND classtype = 6 AND valid = 1;"
                        , goodsDiscount.getDiscountFee() - fixShopOrderDetail.getInt("groupDiscount"), orderDetail.getTradeNo(), orderDetail.getOrderNo(), fixShopOrderDetail.getStr("parent_code"));
                //String discountSql = StrUtil.format("UPDATE car_order_goods_discount SET discount_fee = {}, update_datetime = NOW() WHERE trade_no = '{}' AND order_no = '{}' AND order_type = 2 AND good_code = '{}' AND classtype = 6 AND valid = 1;"
                //        , fixShopOrderDetail.getInt("groupDiscount"), orderDetail.getTradeNo(), orderDetail.getOrderNo(), fixShopOrderDetail.getStr("parent_code"));
                System.out.println(discountSql);
            }
            shopOffLineDiscountFee += fixShopOrderDetail.getInt("fixOffLineDiscountFee", 0);
        }

        CarOrderDiscount orderDiscount = new LambdaQueryChainWrapper<>(orderDiscountDao)
                .eq(CarOrderDiscount::getTradeNo, orderDetail.getTradeNo())
                .eq(CarOrderDiscount::getOrderNo, orderDetail.getOrderNo())
                .eq(CarOrderDiscount::getOrderType, 2).eq(CarOrderDiscount::getClasstype, 6)
                .eq(CarOrderDiscount::getValid, 1).last("limit 1").one();
        String discountSql = StrUtil.format("UPDATE car_order_discount SET discount_range = discount_range - {}, discount_sum = discount_sum - {}, update_datetime = NOW() WHERE trade_no = '{}' AND order_no = '{}' AND order_type = 2 AND classtype = 6 AND valid = 1;"
                , orderDiscount.getDiscountRange() - groupGoodsDiscount, orderDiscount.getDiscountSum() - groupGoodsDiscount, orderDetail.getTradeNo(), orderDetail.getOrderNo());
        //String discountSql = StrUtil.format("UPDATE car_order_discount SET discount_range = {}, discount_sum = {}, update_datetime = NOW() WHERE trade_no = '{}' AND order_no = '{}' AND order_type = 2 AND classtype = 6 AND valid = 1;"
        //        , groupGoodsDiscount, groupGoodsDiscount, orderDetail.getTradeNo(), orderDetail.getOrderNo());
        System.out.println(discountSql);

        CarShoporder shoporder = new LambdaQueryChainWrapper<>(shoporderDao)
                .eq(CarShoporder::getOrderNo, orderDetail.getOrderNo()).last("limit 1").one();
        String shopSql = StrUtil.format("UPDATE car_shoporder SET total_money = total_money - {}, discount_fee = discount_fee - {}, offline_discount_fee = offline_discount_fee - {}, total_fee = total_fee - {}, update_datetime = NOW() WHERE order_no = '{}';"
                , shoporder.getTotalMoney() - shopTotalPrice, shoporder.getDiscountFee() - shopDiscountFee
                , shoporder.getOfflineDiscountFee() - shopOffLineDiscountFee, shoporder.getTotalFee() - shopTotalFee, orderDetail.getOrderNo());
        //String shopSql = StrUtil.format("UPDATE car_shoporder SET total_money = {}, discount_fee = {}, offline_discount_fee = {}, total_fee = {}, update_datetime = NOW() WHERE order_no = '{}';"
        //        , shopTotalPrice, shopDiscountFee, shopOffLineDiscountFee, shopTotalFee, orderDetail.getOrderNo());
        System.out.println(shopSql);

        CarOrderDetail carorderDetail = new LambdaQueryChainWrapper<>(orderDetailDao)
                .eq(CarOrderDetail::getOrderNo, orderDetail.getOrderNo())
                .eq(CarOrderDetail::getOrderType, 2).last("limit 1").one();
        String orderDetailSql = StrUtil.format("UPDATE car_order_detail SET update_datetime = NOW(), total_money = total_money - {}, discount_fee = discount_fee - {}, offline_discount_fee = offline_discount_fee - {}, total_fee = total_fee - {} WHERE order_type = 2 AND order_no = '{}';"
                , carorderDetail.getTotalMoney() - shopTotalPrice, carorderDetail.getDiscountFee() - shopDiscountFee
                , carorderDetail.getOfflineDiscountFee() - shopOffLineDiscountFee, carorderDetail.getTotalFee() - shopTotalFee, orderDetail.getOrderNo());
        //String orderDetailSql = StrUtil.format("UPDATE car_order_detail SET update_datetime = NOW(), total_money = {}, discount_fee = {}, offline_discount_fee = {}, total_fee = {} WHERE order_type = 2 AND order_no = '{}';"
        //        , shopTotalPrice, shopDiscountFee, shopOffLineDiscountFee, shopTotalFee, orderDetail.getOrderNo());
        System.out.println(orderDetailSql);

        CarOrder order = new LambdaQueryChainWrapper<>(carOrderDao).eq(CarOrder::getTradeNo, orderDetail.getTradeNo()).last("limit 1").one();
        int offLinediscountChange = order.getOfflineDiscountFee() - (oilOffLineDiscountFee + shopOffLineDiscountFee);
        int totalFeeChange = order.getTotalFee() - totalFee;
        String orderSql = StrUtil.format("UPDATE car_order SET total_money = total_money - {}, discount_fee = discount_fee - {}, offline_discount_fee = offline_discount_fee - {}, total_fee = total_fee - {}, paymoney = paymoney - {}, settle_money = settle_money - {}, user_cash = user_cash - {}, ar_fee = 0, ar_total = ar_total - {}, paymoney_sum = paymoney_sum - {},  update_datetime = NOW() WHERE trade_no = '{}';"
                , order.getTotalMoney() - totalMoney, order.getDiscountFee() - discountFee, offLinediscountChange, totalFeeChange, totalFeeChange, totalFeeChange, totalFeeChange, totalFeeChange, totalFeeChange, orderDetail.getTradeNo());
        //String orderSql = StrUtil.format("UPDATE car_order SET total_money = {}, discount_fee = {}, offline_discount_fee = {}, total_fee = {}, paymoney = {}, settle_money = {}, user_cash = {}, ar_fee = 0, ar_total = {}, paymoney_sum = {},  update_datetime = NOW() WHERE trade_no = '{}';"
        //        , totalMoney, discountFee, oilOffLineDiscountFee + shopOffLineDiscountFee, totalFee, totalFee, totalFee, totalFee, totalFee, totalFee, orderDetail.getTradeNo());
        System.out.println(orderSql);

        int tempTotalMoneyChange = carOrder.getTotalMoney() - totalMoney;
        int tempTotalFeeChange = carOrder.getTotalFee() - totalFee;
        int tempDiscountChange = carOrder.getDiscountFee() - discountFee;
        String payToolCode = mixPayorder.getPaytoolCode();
        totalMoneyChange += tempTotalMoneyChange;
        totalFeeChange += tempTotalFeeChange;
        discountChange += tempDiscountChange;

        if (payChannelChange.get(payToolCode) != null) {
            JSONObject tempObj = payChannelChange.get(payToolCode);
            tempObj.putOpt("totalMoneyChange", Integer.parseInt(String.valueOf(tempObj.get("totalMoneyChange"))) + tempTotalMoneyChange);
            tempObj.putOpt("totalFeeChange", Integer.parseInt(String.valueOf(tempObj.get("totalFeeChange"))) + tempTotalFeeChange);
            tempObj.putOpt("discountChange", Integer.parseInt(String.valueOf(tempObj.get("discountChange"))) + tempDiscountChange);
            payChannelChange.put(payToolCode, tempObj);
        } else {
            JSONObject tempObj = new JSONObject();
            tempObj.putOpt("totalMoneyChange", tempTotalMoneyChange);
            tempObj.putOpt("totalFeeChange", tempTotalFeeChange);
            tempObj.putOpt("discountChange", tempDiscountChange);
            payChannelChange.put(payToolCode, tempObj);
        }
    }

    private void sumShiftCountData(int stationId) {
        String shiftSql = StrUtil.format("UPDATE car_shiftcount SET goods_total_money = goods_total_money-{}, goods_discount_fee = goods_discount_fee-{}, goods_offline_discount_fee = goods_offline_discount_fee-{}, goods_total_fee = goods_total_fee-{}, total_money = total_money-{}, discount_fee = discount_fee-{}, total_fee = total_fee-{}, paymoney = paymoney-{}, ar_total = ar_total-{}, settle_money = settle_money-{}, user_cash = user_cash-{}, update_datetime = NOW() WHERE id = {};"
                , totalMoneyChange, discountChange, discountChange, totalFeeChange, totalMoneyChange, discountChange
                , totalFeeChange, totalFeeChange, totalFeeChange, totalFeeChange, totalFeeChange, shiftId);
        System.out.println(shiftSql);
        for (String key : payChannelChange.keySet()) {
            JSONObject tempPayChannel = payChannelChange.get(key);
            int tempTotalFee = tempPayChannel.getInt("totalFeeChange");
            if (tempTotalFee == 0) {
                continue;
            }
            String paychannelSql = StrUtil.format("UPDATE car_shiftcount_paychannel SET total_fee = total_fee - {}, paymoney = paymoney - {}, user_cash = user_cash - {}, settle_money = settle_money - {}, ar_total =  ar_total - {}, update_datetime = NOW() WHERE shift_id = {} AND order_type = 1 AND paytool_code = '{}';"
                    , tempTotalFee, tempTotalFee, tempTotalFee, tempTotalFee, tempTotalFee, shiftId, key);
            System.out.println(paychannelSql);
        }
        System.out.println("\r\n");
        currentStation = stationId;
        clearCache();
    }

    /**
     * 获取油站id
     *
     * @param tradeNo 交易号
     * @return 油站id
     **/
    private int getStationIdFromTradeNo(String tradeNo) {
        String stationStr = tradeNo.substring(4, 7);
        return Integer.parseInt(stationStr);
    }

    private void clearCache() {
        totalMoneyChange = 0;
        totalFeeChange = 0;
        discountChange = 0;
        shiftId = 0;
        payChannelChange.clear();
    }
}
