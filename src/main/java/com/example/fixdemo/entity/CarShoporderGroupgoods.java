package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 便利店订单组合商品记录表(CarShoporderGroupgoods)实体类
 *
 * @author makejava
 * @since 2022-02-22 12:27:56
 */
public class CarShoporderGroupgoods implements Serializable {
    private static final long serialVersionUID = 193461558805294879L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Integer stationId;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 商品id
    */
    private Long goodId;
    /**
    * 商品编码
    */
    private String goodCode;
    /**
    * 子商品编码
    */
    private String subGoodCode;
    /**
    * 商品上下级单位倍数
    */
    private Integer unitTimes;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getSubGoodCode() {
        return subGoodCode;
    }

    public void setSubGoodCode(String subGoodCode) {
        this.subGoodCode = subGoodCode;
    }

    public Integer getUnitTimes() {
        return unitTimes;
    }

    public void setUnitTimes(Integer unitTimes) {
        this.unitTimes = unitTimes;
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

}