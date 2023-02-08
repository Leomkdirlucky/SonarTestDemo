package com.example.fixdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (CarOrderDiscount)实体类
 *
 * @author makejava
 * @since 2021-10-28 17:56:15
 */
public class CarOrderDiscount implements Serializable {
    private static final long serialVersionUID = 712624633887512172L;
    /**
    * 序号
    */
    private Integer id;
    /**
    * 交易总订单号
    */
    private String tradeNo;
    /**
    * 订单号（油品订单或者商品订单）
    */
    private String orderNo;
    /**
    * 订单类型，1.油品；2.便利店；3.充值；4.混合订单
    */
    private Object orderType;
    /**
    * 优惠类别。1.基础优惠；2.集团优惠(特权)；3.优惠券；4.线下优惠金额(自定义优惠)；5.油机优惠
    */
    private Object classtype;
    /**
    * 优惠类型（默认0）
    */
    private Object discountType;
    /**
    * 优惠幅度（分）
    */
    private Integer discountRange;
    /**
    * 优惠金额（分）
    */
    private Integer discountSum;
    /**
     * 优惠名称
     */
    private String discountName;
    /**
     * 优惠备注
     */
    private String discountRemark;
    /**
    * 相关序号
    */
    private Integer itemId;
    /**
    * 用户相关优惠ID
    */
    private Integer userItemId;
    /**
    * 用户标识
    */
    private String zhimaid;
    /**
    * 额外信息
    */
    private String extInfo;
    /**
     * 是否有效（0无效；1有效）
     */
    private Object valid;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Object getOrderType() {
        return orderType;
    }

    public void setOrderType(Object orderType) {
        this.orderType = orderType;
    }

    public Object getClasstype() {
        return classtype;
    }

    public void setClasstype(Object classtype) {
        this.classtype = classtype;
    }

    public Object getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Object discountType) {
        this.discountType = discountType;
    }

    public Integer getDiscountRange() {
        return discountRange;
    }

    public void setDiscountRange(Integer discountRange) {
        this.discountRange = discountRange;
    }

    public Integer getDiscountSum() {
        return discountSum;
    }

    public void setDiscountSum(Integer discountSum) {
        this.discountSum = discountSum;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserItemId() {
        return userItemId;
    }

    public void setUserItemId(Integer userItemId) {
        this.userItemId = userItemId;
    }

    public String getZhimaid() {
        return zhimaid;
    }

    public void setZhimaid(String zhimaid) {
        this.zhimaid = zhimaid;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
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

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountRemark() {
        return discountRemark;
    }

    public void setDiscountRemark(String discountRemark) {
        this.discountRemark = discountRemark;
    }
}