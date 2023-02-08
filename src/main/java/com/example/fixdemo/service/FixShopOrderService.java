package com.example.fixdemo.service;

import java.text.ParseException;
import java.util.List;

/**
 * 加德士油卡被扫需求导致便利店基础优惠多减了一次
 *
 * @Description TODO
 * @Author laoyj
 * @Date 2022/12/19 11:44
 */
public interface FixShopOrderService {
    void fixShopOrder() throws ParseException;

    void fixShopOrderHandler(String stationId, String beginTime, String endTime, List<String> tradeList);

    void getShopSEDate();

    void fixShift();

    /**
     * 修复订单成本价
     **/
    void fixOrderGoodPrice() throws Exception;
}
