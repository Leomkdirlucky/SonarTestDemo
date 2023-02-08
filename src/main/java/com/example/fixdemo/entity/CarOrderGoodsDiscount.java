package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单商品优惠详情(CarOrderGoodsDiscount)实体类
 *
 * @author makejava
 * @since 2022-02-21 16:29:40
 */
public class CarOrderGoodsDiscount implements Serializable {
    private static final long serialVersionUID = 701201426011276248L;
    /**
    * 自增id
    */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;
    /**
    * 油站id
    */
    private Integer stationId;
    /**
    * 交易号
    */
    private String tradeNo;
    /**
    * 订单号
    */
    private String orderNo;
    /**
    * 订单类型，1.油品；2.便利店;3.充值
    */
    private Object orderType;
    /**
     * 商品id
     */
    private Long goodId;
    /**
    * 商品编号
    */
    private String goodCode;
    /**
    * 商品名称
    */
    private String goodName;
    /**
     * 商品数量
     */
    private Integer goodCount;
    /**
    * 优惠类别。1.基础优惠；2.集团优惠；3.优惠券；4.线下优惠金额；5.油机优惠；6.组合商品优惠
    */
    private Object classtype;
    /**
     * 促销活动编码
     */
    private String promotionCode;
    /**
    * 基础优惠编码
    */
    private String discountCode;
    /**
    * 基础有优惠名称
    */
    private String discountName;
    /**
    * 1:折扣(金额满X元) 2:油站单价直减(金额满X元) 3:标准单价直减(金额满X元) 4:满额直减(金额满X元) 5.标准单价直减(金额满X元，显示优惠为国家单价直减，四舍五入) 6.油站单价直减(金额满X元，显示优惠为国家单价直减，四舍五入) 7:油站单价直减(金额满X元，显示优惠为国家单价直减，进一取整) 8:折扣(油量满X升) 9:满额直减(油量满X升) 10:油站单价直减(油量满X升，页面显示标准单价直减)；11:任选；12：赠送 13: 促销单价(不受原价影响)
    */
    private Object discountType;
    /**
    * 优惠（幅度、结算金额(任选)、赠送数量）
    */
    private Integer discountValue;
    /**
    * 优惠金额（分）
    */
    private Integer discountFee;
    /**
     * 价格模式（0售价；1.员工价；2.赠品价格；3.促销）
     */
    private Object priceModel;
    /**
    * 是否有效（0无效 1有效）
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
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

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Object getClasstype() {
        return classtype;
    }

    public void setClasstype(Object classtype) {
        this.classtype = classtype;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Object getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Object discountType) {
        this.discountType = discountType;
    }

    public Integer getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Integer discountValue) {
        this.discountValue = discountValue;
    }

    public Integer getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Integer discountFee) {
        this.discountFee = discountFee;
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

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public Object getPriceModel() {
        return priceModel;
    }

    public void setPriceModel(Object priceModel) {
        this.priceModel = priceModel;
    }
}