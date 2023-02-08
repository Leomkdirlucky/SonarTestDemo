package com.example.fixdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 便利店订单总表(CarShoporder)实体类
 *
 * @author makejava
 * @since 2021-10-22 14:17:49
 */
public class CarShoporder implements Serializable {
    private static final long serialVersionUID = 317171838896960294L;
    /**
    * 自增id
    */
    private Integer id;
    /**
     * 第三方原始订单号
     **/
    private String originThirdNo;
    /**
     * 一定规则转换后的第三方订单号
     **/
    private String thirdId;
    /**
    * 支付班次ID
    */
    private Integer shiftId;
    /**
    * 商品订单号
    */
    private String orderNo;
    /**
    * 状态（0.待收款；1.挂单；2.锁单；3线上锁单；4.收款中；5已收款；6.部分退款；7.撤单）
    */
    private Object tradeState;
    /**
    * 商品原总价
    */
    private Integer totalMoney;
    /**
    * 商品优惠金额
    */
    private Integer discountFee;
    /**
    * 商品线上优惠额
    */
    private Integer onlineDiscountFee;
    /**
    * 商品线下优惠额
    */
    private Integer offlineDiscountFee;
    /**
    * 商品总价=商品原总价-商品优惠额
    */
    private Integer totalFee;
    /**
    * 商品数量
    */
    private Integer goodCount;
    /**
    * 支付时间
    */
    private Date payDatetime;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;
    /**
    * 客户端IP
    */
    private String clientIp;
    /**
    * 客户端指纹
    */
    private String clientDevid;
    /**
    * 退款累计数量
    */
    private Integer refundGoodCount;
    /**
    * 退款累计商品原总价
    */
    private Integer refundTotalMoney;
    /**
    * 退款累计商品优惠金额
    */
    private Integer refundDiscountFee;
    /**
    * 退款商品线上优惠额
    */
    private Integer refundOnlineDiscountFee;
    /**
    * 退款商品线下优惠额
    */
    private Integer refundOfflineDiscountFee;
    /**
    * 退款累计商品总价
    */
    private Integer refundTotalFee;
    /**
    * 预留1
    */
    private String reserve1;
    /**
    * 预留2
    */
    private String reserve2;
    /**
    * 操作人
    */
    private String operator;
    /**
    * 是否有效（0无效；1有效）
    */
    private Object valid;
    /**
    * 打印次数
    */
    private Integer printTimes;
    /**
    * 打印更新时间
    */
    private Date printDatetime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Object getTradeState() {
        return tradeState;
    }

    public void setTradeState(Object tradeState) {
        this.tradeState = tradeState;
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

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientDevid() {
        return clientDevid;
    }

    public void setClientDevid(String clientDevid) {
        this.clientDevid = clientDevid;
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

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }

    public Integer getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Integer printTimes) {
        this.printTimes = printTimes;
    }

    public Date getPrintDatetime() {
        return printDatetime;
    }

    public void setPrintDatetime(Date printDatetime) {
        this.printDatetime = printDatetime;
    }

    public String getOriginThirdNo() {
        return originThirdNo;
    }

    public void setOriginThirdNo(String originThirdNo) {
        this.originThirdNo = originThirdNo;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }
}