package com.example.fixdemo.dao;

import cn.hutool.json.JSONObject;
import com.example.fixdemo.entity.CarGoodstockBatch;
import com.example.fixdemo.entity.CarShoporderDetail;

import java.util.List;

/**
 * @Description TODO
 * @Author laoyj
 * @Date 2022/11/9 9:57
 */
public interface FixTradeDao {

    /**
     * 查找订单的子商品售价
     *
     * @param stationId 油站id
     * @param tradeNo   交易号
     * @return 子商品售价
     **/
    List<JSONObject> queryOrderSubGoodsPrice(int stationId, String tradeNo);

    /**
     * 查找订单的商品信息
     *
     * @param stationId 油站id
     * @param tradeNo   交易号
     * @return 商品详情以及父子商品对应关系
     **/
    List<JSONObject> queryShopOrderDetail(int stationId, String tradeNo);

    /**
     * 查找订单组合商品的子商品信息
     *
     * @param stationId 油站id
     * @param tradeNo   交易号
     * @param goodId    商品id
     * @return 组合商品的子商品信息
     **/
    List<JSONObject> queryGroupGoodsList(int stationId, String tradeNo, String goodId);

    List<String> queryRepeatShopOrder(String stationId, String beginTime, String endTime);

    List<String> queryRepeatShopOrder1(String stationId, String beginTime, String endTime);

    List<JSONObject> queryShopOrderDetail1(String orderNo);

    List<JSONObject> queruR1Goods();

    JSONObject queryShiftShopFee(int stationId, int shiftId);

    List<CarShoporderDetail> queryOrderForFixBuyPrice(int stationId, String addDatetime);

    List<JSONObject> queryStockBuyPriceToFix(String orderNo, int stationId);

    JSONObject queryUnitForFixBuyPrice(int stationId, String goodId);
}
