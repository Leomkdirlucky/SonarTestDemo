package com.example.fixdemo.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.fixdemo.dao.*;
import com.example.fixdemo.entity.*;
import com.example.fixdemo.service.FixShopOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author laoyj
 * @since 2022-12-19 11:50:03
 */
@Service
public class FixShopOrderServiceImpl implements FixShopOrderService {
    @Resource
    CarSystemConfigsDao systemConfigsDao;
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

    @Resource
    private CarBonusRecordDao bonusRecordDao;

    @Resource
    private CarInvoiceOrderListDao invoiceOrderListDao;

    @Resource
    private CarShiftcountDao shiftcountDao;

    String beginDate = "2022-11-23 00:00:00";
    String endDate = "2022-12-05 00:00:00";
    String filePath = "E:\\fix.sql";

    @Override
    public void fixShopOrder() throws ParseException {
        appendToFile("-- 执行开始：" + DateUtil.now());
        //List<String> stationList = systemConfigsDao.queryStationIds();
        List<String> stationList = new ArrayList<>();
        stationList.add("407");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (String stationId : stationList) {
            // 分油站
            String tempDate = beginDate;
            while (DateUtil.betweenDay(simpleDateFormat.parse(endDate), simpleDateFormat.parse(tempDate), false) != 0) {
                // 分时间
                fixShopOrderHandler(stationId, tempDate, DateUtil.offsetDay(simpleDateFormat.parse(tempDate), 1).toString(), null);
                // 一天一天处理
                appendToFile("-- " + DateUtil.beginOfDay(simpleDateFormat.parse(tempDate)) + "" + DateUtil.endOfDay(simpleDateFormat.parse(tempDate)));
                tempDate = DateUtil.offsetDay(simpleDateFormat.parse(tempDate), 1).toString();

            }

        }
        appendToFile("-- 执行结束：" + DateUtil.now());
    }

    private void appendToFile(String content) {
        System.out.println(content);
        FileUtil.appendString(content + "\r\n", filePath, Charset.defaultCharset());
    }

    @Override
    public void fixShopOrderHandler(String stationId, String beginTime, String endTime, List<String> tradeList) {
        appendToFile("-- beginTime:" + beginTime + "  endTime:" + endTime);
        if (CollectionUtil.isEmpty(tradeList)) {
            tradeList = new ArrayList<>();
            List<String> resultList = fixTradeDao.queryRepeatShopOrder(stationId, beginTime, endTime);
            List<String> resultList1 = fixTradeDao.queryRepeatShopOrder1(stationId, beginTime, endTime);
            for (String tradeNo : resultList) {
                if (tradeList.contains(tradeNo)) {
                    continue;
                }
                tradeList.add(tradeNo);
            }
            for (String tradeNo : resultList1) {
                if (tradeList.contains(tradeNo)) {
                    continue;
                }
                tradeList.add(tradeNo);
            }
        }
        for (String tradeNo : tradeList) {
            appendToFile("-- tradeNo:" + tradeNo);

            List<CarOrderDiscount> orderDiscountList = new LambdaQueryChainWrapper<>(orderDiscountDao).eq(CarOrderDiscount::getTradeNo, tradeNo).list();
            CarOrderDiscount couponDiscount = orderDiscountList.stream().filter(s -> Convert.toInt(s.getClasstype(), -1) == 3 && Convert.toInt(s.getOrderType(), -1) == 2).findAny().orElse(null);
            CarOrderDiscount errorDiscount = orderDiscountList.stream().filter(s -> Convert.toInt(s.getClasstype(), -1) == 1 && Convert.toInt(s.getOrderType(), -1) == 2 && StrUtil.isNotBlank(s.getExtInfo())).findAny().orElse(null);
            if (errorDiscount == null) {
                appendToFile("error没有找到有问题的优惠！！！" + tradeNo);
                continue;
            }
            String orderNo = errorDiscount.getOrderNo();
            // 这里输出有商品列表的表shoporderdetail\ordergoodsdiscount
            // 线上优惠、总优惠
            int onlineDiscountFee = 0, totalDiscount = 0;
            JSONObject sumObj = null;
            if (couponDiscount != null) {
                // 有代金券优惠，要重算每件商品的平摊到的券优惠
                int onLineDiscountSum = 0;
                for (CarOrderDiscount carOrderDiscount : orderDiscountList) {
                    if (Convert.toInt(carOrderDiscount.getClasstype(), -1) == 3 && Convert.toInt(carOrderDiscount.getOrderType(), -1) == 2) {
                        onLineDiscountSum += couponDiscount.getDiscountSum();
                    }
                }
                sumObj = equalOnlineDiscount(tradeNo, orderNo, onLineDiscountSum);
            } else {
                // 没有线上优惠
                String orderGoodsDiscountSql = StrUtil.format("UPDATE car_order_goods_discount SET valid = 0, update_datetime = now() WHERE trade_no = '{}' AND order_no = '{}' AND classtype = 3;"
                        , tradeNo, orderNo);
                appendToFile(orderGoodsDiscountSql);

                List<CarShoporderDetail> detailList = new LambdaQueryChainWrapper<>(shoporderDetailDao).eq(CarShoporderDetail::getOrderNo, orderNo).list();
                for (CarShoporderDetail shopOrderDetail : detailList) {
                    totalDiscount += shopOrderDetail.getDiscountFee();
                    if (shopOrderDetail.getOnlineDiscountFee() != 0) {
                        totalDiscount -= shopOrderDetail.getOnlineDiscountFee();
                        // 优惠后单价
                        int discountPrice = (shopOrderDetail.getTotalFee() + shopOrderDetail.getOnlineDiscountFee()) / shopOrderDetail.getGoodCount();
                        String shopOrderDetailsql = StrUtil.format("UPDATE car_shoporder_detail SET discount_fee = discount_fee - {}, online_discount_fee = online_discount_fee - {}, total_fee = total_fee + {},discount_good_price = discount_good_price + {}, update_datetime = NOW() WHERE order_no = '{}' AND good_id = '{}';"
                                , shopOrderDetail.getOnlineDiscountFee(), shopOrderDetail.getOnlineDiscountFee()
                                , shopOrderDetail.getOnlineDiscountFee(), discountPrice - shopOrderDetail.getDiscountGoodPrice()
                                , orderNo, shopOrderDetail.getGoodId());
                        appendToFile(shopOrderDetailsql);
                    }
                }
            }

            // 有问题的优惠
            int errorDiscountFee;
            errorDiscountFee = errorDiscount.getDiscountSum();

            appendToFile(StrUtil.format("UPDATE car_order_discount SET valid = 0, update_datetime = now() WHERE trade_no = '{}' AND order_no = '{}' AND id = '{}';", errorDiscount.getTradeNo(), errorDiscount.getOrderNo(), errorDiscount.getId()));

            CarShoporder shoporder = new LambdaQueryChainWrapper<>(shoporderDao)
                    .eq(CarShoporder::getOrderNo, orderNo).last("limit 1").one();
            if (couponDiscount == null) {
                errorDiscountFee = shoporder.getOnlineDiscountFee();
            }
            int discountFee = shoporder.getDiscountFee() - errorDiscountFee, onLineDiscountFee = shoporder.getOnlineDiscountFee() - errorDiscountFee, shoptotalFee = shoporder.getTotalFee() + errorDiscountFee, totalFee = 0;
            if (sumObj != null) {
                discountFee = sumObj.getInt("discountFee");
                onLineDiscountFee = sumObj.getInt("onlineDiscountFee");
                shoptotalFee = sumObj.getInt("totalFee");
            }
            String shopSql = StrUtil.format("UPDATE car_shoporder SET discount_fee = discount_fee - {}, online_discount_fee = online_discount_fee - {}, total_fee = total_fee + {}, update_datetime = NOW() WHERE order_no = '{}';"
                    , shoporder.getDiscountFee() - discountFee, shoporder.getOnlineDiscountFee() - onLineDiscountFee, shoptotalFee - shoporder.getTotalFee(), orderNo);
            appendToFile(shopSql);

            CarOrderDetail carorderDetail = new LambdaQueryChainWrapper<>(orderDetailDao)
                    .eq(CarOrderDetail::getOrderNo, orderNo)
                    .eq(CarOrderDetail::getOrderType, 2).last("limit 1").one();
            String orderDetailSql = StrUtil.format("UPDATE car_order_detail SET update_datetime = NOW(), discount_fee = discount_fee - {}, online_discount_fee = online_discount_fee - {}, total_fee = total_fee + {} WHERE order_type = 2 AND order_no = '{}';"
                    , carorderDetail.getDiscountFee() - discountFee, carorderDetail.getOnlineDiscountFee() - onLineDiscountFee, shoptotalFee - carorderDetail.getTotalFee(), orderNo);
            appendToFile(orderDetailSql);

            CarOrderDetail oilorderDetail = new LambdaQueryChainWrapper<>(orderDetailDao)
                    .eq(CarOrderDetail::getTradeNo, tradeNo).eq(CarOrderDetail::getValid, 1)
                    .eq(CarOrderDetail::getOrderType, 1).last("limit 1").one();
            totalFee += shoptotalFee;
            if (oilorderDetail != null) {
                totalFee += oilorderDetail.getTotalFee();
            }
            CarOrder order = new LambdaQueryChainWrapper<>(carOrderDao).eq(CarOrder::getTradeNo, tradeNo).last("limit 1").one();
            String orderSql = StrUtil.format("UPDATE car_order SET discount_fee = discount_fee - {}, online_discount_fee = online_discount_fee - {}, total_fee = total_fee + {}, paymoney = paymoney + {}, settle_money = settle_money + {}, user_cash = user_cash + {}, ar_total = ar_total + {}, paymoney_sum = paymoney_sum + {},  update_datetime = NOW() WHERE trade_no = '{}';"
                    , order.getDiscountFee() - discountFee, order.getOnlineDiscountFee() - onLineDiscountFee, totalFee - order.getTotalFee()
                    , totalFee - order.getPaymoney(), totalFee - order.getSettleMoney(), totalFee - order.getUserCash(), totalFee - order.getPaymoneySum(), totalFee - order.getTotalFee(), tradeNo);
            appendToFile(orderSql);

            List<CarMixPayorder> mixPayorderList = new LambdaQueryChainWrapper<>(mixPayorderDao).eq(CarMixPayorder::getTradeNo, tradeNo).list();
            if (mixPayorderList.size() > 1) {
                appendToFile("error有组合支付的订单！！！" + tradeNo);
                continue;
            } else {
                CarMixPayorder carMixPayorder = mixPayorderList.get(0);
                String payorderSql = StrUtil.format("UPDATE car_mix_payorder SET total_fee = total_fee + {}, paymoney = paymoney + {}, ar_total = ar_total + {}, user_cash = user_cash + {}, settle_money = settle_money + {}, update_datetime = NOW() WHERE trade_no = '{}';"
                        , totalFee - carMixPayorder.getTotalFee(), totalFee - carMixPayorder.getPaymoney(), totalFee - carMixPayorder.getArTotal()
                        , totalFee - carMixPayorder.getUserCash(), totalFee - carMixPayorder.getSettleMoney(), tradeNo);
                appendToFile(payorderSql);

                String shiftSql = StrUtil.format("UPDATE car_shiftcount SET goods_discount_fee = goods_discount_fee-{}, goods_online_discount_fee = goods_online_discount_fee-{}, goods_total_fee = goods_total_fee+{}, discount_fee = discount_fee-{}, total_fee = total_fee+{}, paymoney = paymoney+{}, ar_total = ar_total+{}, settle_money = settle_money+{}, user_cash = user_cash+{}, update_datetime = NOW() WHERE id = {};"
                        , shoporder.getDiscountFee() - discountFee, shoporder.getOnlineDiscountFee() - onLineDiscountFee, shoptotalFee - shoporder.getTotalFee()
                        , order.getDiscountFee() - discountFee, totalFee - order.getTotalFee()
                        , totalFee - order.getPaymoney(), totalFee - carMixPayorder.getArTotal()
                        , totalFee - order.getSettleMoney(), totalFee - order.getUserCash(), carMixPayorder.getShiftId());
                appendToFile(shiftSql);

                String paychannelSql = StrUtil.format("UPDATE car_shiftcount_paychannel SET total_fee = total_fee + {}, paymoney = paymoney + {}, user_cash = user_cash + {}, settle_money = settle_money + {}, ar_total =  ar_total + {}, update_datetime = NOW() WHERE shift_id = {} AND order_type = 1 AND paytool_code = '{}';"
                        , totalFee - order.getTotalFee(), totalFee - order.getPaymoney(), totalFee - order.getUserCash()
                        , totalFee - order.getSettleMoney(), totalFee - carMixPayorder.getArTotal()
                        , carMixPayorder.getShiftId(), carMixPayorder.getPaytoolCode());
                appendToFile(paychannelSql);
            }

            List<CarBonusRecord> list = new LambdaQueryChainWrapper<>(bonusRecordDao).eq(CarBonusRecord::getTradeNo, tradeNo).list();
            if (CollectionUtil.isNotEmpty(list)) {
                appendToFile("-- 已发积分：" + tradeNo);
            } else {
                appendToFile("-- 未发积分：" + tradeNo);
            }

            CarInvoiceOrderList invoiceOrder = new LambdaQueryChainWrapper<>(invoiceOrderListDao).eq(CarInvoiceOrderList::getTradeNo, tradeNo).last("limit 1").one();
            if (invoiceOrder != null) {
                String status = "";
                switch (invoiceOrder.getInvoiceStatus()) {
                    case 0:
                        status = "未开票";
                        break;
                    case 1:
                        status = "已提交开票";
                        break;
                    case 2:
                        status = "已完成开票";
                        break;
                    case 3:
                        status = "已取消开票";
                        break;
                    case 4:
                        status = "开票失败";
                        break;
                    case 5:
                        status = "待处理";
                        break;
                }
                appendToFile("-- 已开发票：" + tradeNo + "，开票状态：" + status);
            } else {
                appendToFile("-- 未开发票：" + tradeNo);
            }

        }
    }

    private JSONObject equalOnlineDiscount(String tradeNo, String orderNo, int onLineDiscount) {
        List<CarOrderGoodsDiscount> goodsDiscountList = new LambdaQueryChainWrapper<>(goodsDiscountDao).eq(CarOrderGoodsDiscount::getTradeNo, tradeNo).eq(CarOrderGoodsDiscount::getValid, 1).list();
        List<JSONObject> shopOrderDetailList = fixTradeDao.queryShopOrderDetail1(orderNo);
        Map<String, List<CarOrderGoodsDiscount>> goodsMap = goodsDiscountList.stream().collect(Collectors.groupingBy(CarOrderGoodsDiscount::getGoodCode));

        // 减去线下优惠后的实付金额
        int calcTotalFee = 0;
        List<JSONObject> calcList = new ArrayList<>();
        for (String goodCode : goodsMap.keySet()) {
            JSONObject tempShop = new JSONObject();
            JSONObject shopDetail = shopOrderDetailList.stream().filter(s -> s.getStr("good_code").equals(goodCode)).findAny().orElse(null);
            if (shopDetail == null) {
                appendToFile("error没有查询到订单详情！！！" + tradeNo);
                break;
            }
            tempShop.putOpt("goodCode", goodCode);
            tempShop.putOpt("good_id", shopDetail.getStr("good_id"));
            int offLineDiscount = 0;
            for (CarOrderGoodsDiscount carOrderGoodsDiscount : goodsMap.get(goodCode)) {
                if (Convert.toInt(carOrderGoodsDiscount.getClasstype(), -1) != 3) {
                    offLineDiscount += carOrderGoodsDiscount.getDiscountFee();
                }
            }
            tempShop.putOpt("offLineDiscount", offLineDiscount);  // 线下优惠
            tempShop.putOpt("totalMoney", shopDetail.getInt("total_money"));
            tempShop.putOpt("good_count", shopDetail.getInt("good_count"));
            tempShop.putOpt("totalFee", shopDetail.getInt("total_money") - offLineDiscount);
            calcList.add(tempShop);

            calcTotalFee += tempShop.getInt("totalFee");
        }

        int usedDiscount = 0;
        int discountFee = 0, onlineDiscountFee = 0, totalFee = 0;
        List<CarShoporderDetail> calcDetailList = new LambdaQueryChainWrapper<>(shoporderDetailDao).eq(CarShoporderDetail::getOrderNo, orderNo).eq(CarShoporderDetail::getValid, 1).list();
        for (int i = 0; i < calcList.size(); i++) {
            JSONObject tempShop = calcList.get(i);
            CarOrderGoodsDiscount goodsDiscount = goodsDiscountList.stream().filter(s -> s.getGoodCode().equals(tempShop.getStr("goodCode")) && Convert.toInt(s.getClasstype()) == 3).findAny().orElse(null);
            CarShoporderDetail tempShopDetail = calcDetailList.stream().filter(s -> Convert.toStr(s.getGoodId()).equals(tempShop.getStr("good_id"))).findAny().orElse(null);
            if (goodsDiscount == null || tempShopDetail == null) {
                appendToFile("error没有查询到商品优惠详情！！！" + tempShop.getStr("goodCode"));
                break;
            }
            int tempOnlineDiscount;  // 线上优惠
            if (i == calcList.size() - 1) {
                tempOnlineDiscount = onLineDiscount - usedDiscount;
            } else {
                tempOnlineDiscount = new BigDecimal(tempShop.getDouble("totalFee") / calcTotalFee * onLineDiscount).setScale(0, RoundingMode.HALF_UP).intValue();
            }

            int tempDiscount = tempShopDetail.getOfflineDiscountFee() + tempOnlineDiscount;
            int tempTotalFee = tempShopDetail.getTotalMoney() - tempDiscount;
            int tempDiscountPrice = tempTotalFee / tempShopDetail.getGoodCount();
            discountFee += tempDiscount;  // 汇总优惠
            onlineDiscountFee += tempOnlineDiscount;  // 汇总线上优惠
            totalFee += tempTotalFee;  // 汇总实付
            String shopOrderDetailsql = StrUtil.format("UPDATE car_shoporder_detail SET discount_fee = discount_fee - {}, online_discount_fee = online_discount_fee - {}, total_fee = total_fee + {},discount_good_price = discount_good_price + {}, update_datetime = NOW() WHERE order_no = '{}' AND good_id = '{}';"
                    , tempShopDetail.getDiscountFee() - tempDiscount
                    , tempShopDetail.getOnlineDiscountFee() - tempOnlineDiscount
                    , tempTotalFee - tempShopDetail.getTotalFee(), tempShopDetail.getDiscountGoodPrice() - tempDiscountPrice
                    , orderNo, tempShop.getStr("good_id"));
            appendToFile(shopOrderDetailsql);
            String goodsDiscountSql = StrUtil.format("UPDATE car_order_goods_discount SET discount_fee = discount_fee - {}, update_datetime = NOW() WHERE trade_no = '{}' AND order_no = '{}' AND classtype = 3 AND good_code = '{}';"
                    , goodsDiscount.getDiscountFee() - tempOnlineDiscount, tradeNo, orderNo, tempShop.getStr("goodCode"));
            appendToFile(goodsDiscountSql);
            usedDiscount += tempOnlineDiscount;
        }
        JSONObject result = new JSONObject();
        result.putOpt("discountFee", discountFee);
        result.putOpt("onlineDiscountFee", onlineDiscountFee);
        result.putOpt("totalFee", totalFee);
        return result;
    }

    @Override
    public void getShopSEDate() {
        List<JSONObject> goodlist = fixTradeDao.queruR1Goods();
        List<JSONObject> resultList = goodlist.stream().distinct().collect(Collectors.toList());
        System.out.println("true");
    }

    @Override
    public void fixShift() {
        int stationId = 407;
        for (int i = 683; i < 702; i++) {
            JSONObject shopObj = fixTradeDao.queryShiftShopFee(stationId, i);
            CarShiftcount shiftcount = new LambdaQueryChainWrapper<>(shiftcountDao)
                    .eq(CarShiftcount::getId, i).eq(CarShiftcount::getStationId, stationId).last("limit 1").one();
            String shiftSql = StrUtil.format("UPDATE car_shiftcount SET goods_discount_fee = goods_discount_fee-{}, goods_online_discount_fee = goods_online_discount_fee-{}, goods_total_fee = goods_total_fee+{}, update_datetime = NOW() WHERE id = {};"
                    , shiftcount.getGoodsDiscountFee() - shopObj.getInt("discount")
                    , shiftcount.getGoodsOnlineDiscountFee() - shopObj.getInt("onlineDiscount")
                    , shiftcount.getGoodsTotalFee() - shopObj.getInt("totalFee"), i);
            appendToFile(shiftSql);
        }
    }

    /**
     * 修复订单成本价
     **/
    @Override
    public void fixOrderGoodPrice() throws Exception {
        int stationId = 940;
        String addDatetime = "2022-11-10 00:00:00";
        // 查询订单号列表
        List<CarShoporderDetail> shopList = fixTradeDao.queryOrderForFixBuyPrice(stationId, addDatetime);
        //List<CarShoporderDetail> shopList = new LambdaQueryChainWrapper<>(shoporderDetailDao).eq(CarShoporderDetail::getOrderNo, "2010141002301181849444132039").list();
        Map<String, List<CarShoporderDetail>> shopMap = shopList.stream().collect(Collectors.groupingBy(CarShoporderDetail::getOrderNo));
        String fixSql = "UPDATE car_shoporder_detail SET update_datetime = NOW(), buy_price = buy_price - {}, buy_money = buy_money - {} WHERE id = {} AND order_no = {};";
        for (String orderNo : shopMap.keySet()) {
            List<CarShoporderDetail> shopDetailList = shopMap.get(orderNo);
            // 查询成本价，库存变动流水链表批次库存表
            List<JSONObject> stockBatchList = fixTradeDao.queryStockBuyPriceToFix(orderNo, stationId);
            for (CarShoporderDetail shopDetail : shopDetailList) {
                Long goodId = shopDetail.getGoodId();
                int unitTimes = 1;
                JSONObject stockBatch = stockBatchList.stream()
                        .filter(s -> Objects.equals(s.getLong("id", 0L), goodId))
                        .findAny().orElse(null);
                if (stockBatch == null) {
                    // 没获取到可能是关联关系的原因
                    JSONObject unitObj = fixTradeDao.queryUnitForFixBuyPrice(stationId, Convert.toStr(goodId));
                    if (unitObj == null) {
                        appendToFile(StrUtil.format("-- 未获取到商品成本价1:{}，{}", orderNo, goodId));
                        continue;
                    }
                    stockBatch = stockBatchList.stream()
                            .filter(s -> Objects.equals(s.getStr("good_code", ""), unitObj.getStr("sub_good_code", "")))
                            .findAny().orElse(null);
                    if (stockBatch == null) {
                        appendToFile(StrUtil.format("-- 未获取到商品成本价2:{}，{}", orderNo, goodId));
                        continue;
                    }
                    unitTimes = unitObj.getInt("unit_times", 1);
                }
                int buyPrice = stockBatch.getInt("buy_price", 0);
                int buyMoney = buyPrice * shopDetail.getGoodCount() * unitTimes;
                if (buyPrice != shopDetail.getBuyPrice() || buyMoney != shopDetail.getBuyMoney()) {
                    appendToFile("-- orderNo:" + orderNo);
                    appendToFile(StrUtil.format(fixSql
                            , shopDetail.getBuyPrice() - buyPrice
                            , shopDetail.getBuyMoney() - buyMoney
                            , shopDetail.getId(), orderNo));
                }
            }
        }

    }
}
