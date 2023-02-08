package com.example.fixdemo.service;

/**
 * 木棉南调拨和自定义出库产生重复的批次库存记录，再次出入库时批次库存数量双倍处理了
 * @Description TODO
 * @Author laoyj
 * @Date 2022/10/24 17:05
 */
public interface FixStockService {
    /**
     * 修复批次库存和仓库库存不相等的问题
     *
     * @param stationId 油站id
     * @param goodCode  商品编码
     * @return 修复结果
     **/
    boolean fixBatchStock(int stationId, String goodCode);

    /**
     * 清除负数和重复库存的记录
     *
     * @param stationId 油站id
     * @param goodCode  商品编码
     **/
    void clearErrorStock(int stationId, String goodCode);
}
