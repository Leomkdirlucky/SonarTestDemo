package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品批次库存表(CarGoodstockBatch)实体类
 *
 * @author makejava
 * @since 2021-05-14 18:17:37
 */
public class CarGoodstockBatch implements Serializable {
    private static final long serialVersionUID = -41870902226679667L;
    /**
    * 油站id
    */
    private Integer stationId;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 库存批次号
    */
    private String stockMainkey;
    /**
    * 商品编码
    */
    private String goodCode;
    /**
    * 条码
    */
    private String stripeCode;
    /**
    * 进货价
    */
    private Integer buyPrice;
    /**
    * 库存
    */
    private Integer stockNum;
    /**
    * 操作时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;
    /**
    * 备注
    */
    private String remark;
    /**
    * 仓库编号
    */
    private String warehouseCode;


    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockMainkey() {
        return stockMainkey;
    }

    public void setStockMainkey(String stockMainkey) {
        this.stockMainkey = stockMainkey;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getStripeCode() {
        return stripeCode;
    }

    public void setStripeCode(String stripeCode) {
        this.stripeCode = stripeCode;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Date getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(Date addDatetime) {
        this.addDatetime = addDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

}