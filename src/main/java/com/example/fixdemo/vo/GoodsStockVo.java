package com.example.fixdemo.vo;

import lombok.Data;

/**
 * @author laoyj
 * @since 2022-10-24 17:12:17
 */
@Data
public class GoodsStockVo {
    /**
     * 仓库编码
     **/
    String whCode;
    /**
     * 商品编码
     **/
    String goodCode;
    /**
     * 商品条码
     **/
    String stripeCode;
    /**
     * 批次数
     **/
    int stockCount;
    /**
     * 批次库存
     **/
    int batchStockNum;
    /**
     * 仓库库存
     **/
    int warehouseStockNum;
    /**
     * 差异值
     **/
    int differNum;
}
