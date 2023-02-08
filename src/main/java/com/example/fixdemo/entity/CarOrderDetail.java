package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易订单详细表(CarOrderDetail)实体类
 *
 * @author makejava
 * @since 2021-10-22 09:48:50
 */
public class CarOrderDetail implements Serializable {
    private static final long serialVersionUID = -65106754251748356L;
    /**
    * 自增id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 交易号
    */
    private String tradeNo;
    /**
    * 订单类型，1.油品；2.便利店;3.充值
    */
    private Object orderType;
    /**
    * 订单号（油品订单或者商品订单）
    */
    private String orderNo;
    /**
    * 发票单号
    */
    private String invoiceNo;
    /**
    * 发票代号
    */
    private String invoiceCode;
    /**
    * 税号
    */
    private String invoiceTaxnum;
    /**
    * 开票抬头
    */
    private String invoiceTitle;
    /**
    * 开票时间
    */
    private Date invoiceDatetime;
    /**
    * 开票状态
    */
    private Object invoiceState;
    /**
    * 退款时间
    */
    private Date refundDatetime;
    /**
    * 退款状态（0，无退款，1部分退款，2撤销）
    */
    private Object refundState;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;
    /**
    * 是否有效(0.无效，1有效)
    */
    private Object valid;
    /**
    * 手动关联订单时候，关联线上油枪
    */
    private Integer linkGunid;
    /**
    * 关联订单的额外信息
    */
    private String linkExtinfo;
    /**
    * 状态（0.待收款；1.挂单；2.锁单；3线上锁单；4.收款中；5已收款；6.部分退款；7.撤单）
    */
    private Object tradeState;
    /**
    * 商品名称（油品名称）以下为了实现油品快照
    */
    private String goodName;
    /**
    * 商品数量（油量）
    */
    private Integer goodCount;
    /**
    * 商品单位（升）
    */
    private String goodUnit;
    /**
    * 商品单价（油价）
    */
    private Integer goodPrice;
    /**
    * 商品编号（油品编号）
    */
    private Integer goodCode;
    /**
    * 商品原金额
    */
    private Integer totalMoney;
    /**
    * 商品级优惠金额（油品优惠）
    */
    private Integer discountFee;
    /**
    * 累计商品线上优惠金额
    */
    private Integer onlineDiscountFee;
    /**
    * 累计商品线下优惠金额
    */
    private Integer offlineDiscountFee;
    
    private Integer totalFee;
    /**
    * 累计退款商品数量
    */
    private Integer refundGoodCount;
    /**
    * 退款累计商品原金额
    */
    private Integer refundTotalMoney;
    /**
    * 退款累计商品优惠金额
    */
    private Integer refundDiscountFee;
    /**
    * 退款累计商品线上优惠金额
    */
    private Integer refundOnlineDiscountFee;
    /**
    * 退款累计商品线下优惠金额
    */
    private Integer refundOfflineDiscountFee;
    
    private Integer refundTotalFee;
    /**
    * 线上更新发票状态时间
    */
    private Date invoiceChagetime;


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

    public Object getOrderType() {
        return orderType;
    }

    public void setOrderType(Object orderType) {
        this.orderType = orderType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getInvoiceCode() {
        return invoiceCode;
    }

    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public String getInvoiceTaxnum() {
        return invoiceTaxnum;
    }

    public void setInvoiceTaxnum(String invoiceTaxnum) {
        this.invoiceTaxnum = invoiceTaxnum;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public Date getInvoiceDatetime() {
        return invoiceDatetime;
    }

    public void setInvoiceDatetime(Date invoiceDatetime) {
        this.invoiceDatetime = invoiceDatetime;
    }

    public Object getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(Object invoiceState) {
        this.invoiceState = invoiceState;
    }

    public Date getRefundDatetime() {
        return refundDatetime;
    }

    public void setRefundDatetime(Date refundDatetime) {
        this.refundDatetime = refundDatetime;
    }

    public Object getRefundState() {
        return refundState;
    }

    public void setRefundState(Object refundState) {
        this.refundState = refundState;
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

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }

    public Integer getLinkGunid() {
        return linkGunid;
    }

    public void setLinkGunid(Integer linkGunid) {
        this.linkGunid = linkGunid;
    }

    public String getLinkExtinfo() {
        return linkExtinfo;
    }

    public void setLinkExtinfo(String linkExtinfo) {
        this.linkExtinfo = linkExtinfo;
    }

    public Object getTradeState() {
        return tradeState;
    }

    public void setTradeState(Object tradeState) {
        this.tradeState = tradeState;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public String getGoodUnit() {
        return goodUnit;
    }

    public void setGoodUnit(String goodUnit) {
        this.goodUnit = goodUnit;
    }

    public Integer getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Integer goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(Integer goodCode) {
        this.goodCode = goodCode;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Integer discountFee) {
        this.discountFee = discountFee;
    }

    public Integer getOnlineDiscountFee() {
        return onlineDiscountFee;
    }

    public void setOnlineDiscountFee(Integer onlineDiscountFee) {
        this.onlineDiscountFee = onlineDiscountFee;
    }

    public Integer getOfflineDiscountFee() {
        return offlineDiscountFee;
    }

    public void setOfflineDiscountFee(Integer offlineDiscountFee) {
        this.offlineDiscountFee = offlineDiscountFee;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getRefundGoodCount() {
        return refundGoodCount;
    }

    public void setRefundGoodCount(Integer refundGoodCount) {
        this.refundGoodCount = refundGoodCount;
    }

    public Integer getRefundTotalMoney() {
        return refundTotalMoney;
    }

    public void setRefundTotalMoney(Integer refundTotalMoney) {
        this.refundTotalMoney = refundTotalMoney;
    }

    public Integer getRefundDiscountFee() {
        return refundDiscountFee;
    }

    public void setRefundDiscountFee(Integer refundDiscountFee) {
        this.refundDiscountFee = refundDiscountFee;
    }

    public Integer getRefundOnlineDiscountFee() {
        return refundOnlineDiscountFee;
    }

    public void setRefundOnlineDiscountFee(Integer refundOnlineDiscountFee) {
        this.refundOnlineDiscountFee = refundOnlineDiscountFee;
    }

    public Integer getRefundOfflineDiscountFee() {
        return refundOfflineDiscountFee;
    }

    public void setRefundOfflineDiscountFee(Integer refundOfflineDiscountFee) {
        this.refundOfflineDiscountFee = refundOfflineDiscountFee;
    }

    public Integer getRefundTotalFee() {
        return refundTotalFee;
    }

    public void setRefundTotalFee(Integer refundTotalFee) {
        this.refundTotalFee = refundTotalFee;
    }

    public Date getInvoiceChagetime() {
        return invoiceChagetime;
    }

    public void setInvoiceChagetime(Date invoiceChagetime) {
        this.invoiceChagetime = invoiceChagetime;
    }

}