package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品详情表(CarShoporderDetail)实体类
 *
 * @author makejava
 * @since 2021-10-22 11:22:54
 */
public class CarShoporderDetail implements Serializable {
    private static final long serialVersionUID = -96526141893742739L;
    /**
    * 自增id
    */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
    * 商品金额
    */
    private Integer totalMoney;
    /**
    * 商品优惠额
    */
    private Integer discountFee;
    /**
    * 线下累计商品优惠金额
    */
    private Integer offlineDiscountFee;
    /**
    * 线上累计商品优惠金额
    */
    private Integer onlineDiscountFee;
    /**
    * 商品实收额=商品金额-商品优惠额
    */
    private Integer totalFee;
    /**
    * 商品订单号
    */
    private String orderNo;
    /**
    * 商品名称
    */
    private String goodName;
    /**
    * 商品数量
    */
    private Integer goodCount;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;
    /**
    * 商品id
    */
    private Long goodId;
    /**
    * 商品单价
    */
    private Integer goodPrice;
    /**
    * 优惠后单价
    */
    private Integer discountGoodPrice;
    /**
     * 价格模式（0售价；1.员工价；2.赠品价格；3.促销）
     */
    private Object priceModel;
    /**
    * 进货价（扣库存时候需要维护对应批次的进货价）
    */
    private Integer buyPrice;
    /**
    * 成本金额
    */
    private Integer buyMoney;
    /**
    * 退款累计商品数量
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
    * 退款线下累计商品优惠金额
    */
    private Integer refundOfflineDiscountFee;
    /**
    * 退款线上累计商品优惠金额
    */
    private Integer refundOnlineDiscountFee;
    /**
    * 退款累计商品总价
    */
    private Integer refundTotalFee;
    /**
    * 状态（0.待收款；1.挂单；2.锁单；3线上锁单；4.收款中；5已收款；6.部分退款；7.撤单）
    */
    private Object tradeState;
    /**
    * 退款状态（0，无退款，1部分退款，2撤销）
    */
    private Object refundState;
    /**
    * 退款时间
    */
    private Date refundDatetime;
    /**
    * 是否有效（0无效；1有效）
    */
    private Object valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Integer getOfflineDiscountFee() {
        return offlineDiscountFee;
    }

    public void setOfflineDiscountFee(Integer offlineDiscountFee) {
        this.offlineDiscountFee = offlineDiscountFee;
    }

    public Integer getOnlineDiscountFee() {
        return onlineDiscountFee;
    }

    public void setOnlineDiscountFee(Integer onlineDiscountFee) {
        this.onlineDiscountFee = onlineDiscountFee;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Integer getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Integer goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getDiscountGoodPrice() {
        return discountGoodPrice;
    }

    public void setDiscountGoodPrice(Integer discountGoodPrice) {
        this.discountGoodPrice = discountGoodPrice;
    }

    public Object getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(Object priceModel) {
        this.priceModel = priceModel;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Integer getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(Integer buyMoney) {
        this.buyMoney = buyMoney;
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

    public Integer getRefundOfflineDiscountFee() {
        return refundOfflineDiscountFee;
    }

    public void setRefundOfflineDiscountFee(Integer refundOfflineDiscountFee) {
        this.refundOfflineDiscountFee = refundOfflineDiscountFee;
    }

    public Integer getRefundOnlineDiscountFee() {
        return refundOnlineDiscountFee;
    }

    public void setRefundOnlineDiscountFee(Integer refundOnlineDiscountFee) {
        this.refundOnlineDiscountFee = refundOnlineDiscountFee;
    }

    public Integer getRefundTotalFee() {
        return refundTotalFee;
    }

    public void setRefundTotalFee(Integer refundTotalFee) {
        this.refundTotalFee = refundTotalFee;
    }

    public Object getTradeState() {
        return tradeState;
    }

    public void setTradeState(Object tradeState) {
        this.tradeState = tradeState;
    }

    public Object getRefundState() {
        return refundState;
    }

    public void setRefundState(Object refundState) {
        this.refundState = refundState;
    }

    public Date getRefundDatetime() {
        return refundDatetime;
    }

    public void setRefundDatetime(Date refundDatetime) {
        this.refundDatetime = refundDatetime;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }
}