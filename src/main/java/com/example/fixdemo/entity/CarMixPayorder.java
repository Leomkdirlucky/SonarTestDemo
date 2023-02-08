package com.example.fixdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付工具信息总表(CarMixPayorder)实体类
 *
 * @author makejava
 * @since 2021-10-27 18:45:11
 */
public class CarMixPayorder implements Serializable {
    private static final long serialVersionUID = -19926434664595368L;
    
    private Integer id;
    /**
    * 班次ID
    */
    private Integer shiftId;
    /**
    * 油品编号
    */
    private String oiltypeCode;
    /**
    * 油量
    */
    private Integer oilsum;
    /**
    * 站级总单号(car_order)
    */
    private String tradeNo;
    /**
    * 支付凭证
    */
    private String paymentNo;
    /**
    * 支付工具编号
    */
    private String paytoolCode;
    /**
    * 支付工具名称
    */
    private String paytoolName;
    /**
    * 支付方式编号
    */
    private String paychannelCode;
    /**
    * 支付方式名称
    */
    private String paychannelName;
    /**
    * 交易状态（0.待支付；1.支付成功.；2..支付失败；3.部分退款；4.撤单）.
    */
    private Integer tradeState;
    /**
    * 商品总价
    */
    private Integer totalFee;
    /**
    * 支付优惠额
    */
    private Integer payDiscount;
    /**
    * 实付额=商品总价-支付优惠额
    */
    private Integer paymoney;
    /**
    * 结算额=实收额（若是含有平台后结算则≠）
    */
    private Integer arTotal;
    /**
    * 手续费
    */
    private Integer arFee;
    /**
    * 用户实际付款
    */
    private Integer userCash;
    /**
    * 结算额
    */
    private Integer settleMoney;
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
    * 退款累计实付额
    */
    private Integer refundPaymoney;
    /**
    * 退款累计支付优惠金额
    */
    private Integer refundPayDiscount;
    /**
    * 退款累计应收金额
    */
    private Integer refundArTotal;
    /**
    * 退款累计手续费
    */
    private Integer refundArFee;
    /**
    * 退款累计应收款
    */
    private Integer refundSettleMoney;
    /**
    * 退款累计用户实际支付
    */
    private Integer refundUserCash;
    /**
    * 退款累计商品总价
    */
    private Integer refundTotalFee;
    /**
    * 支付完成时间
    */
    private Date payDatetime;
    /**
    * 最后一次退款时间
    */
    private Date refundDatetime;
    /**
    * 商户号（若下线打标签使用支付工具中文）
    */
    private String mchId;
    /**
    *  实体卡号
    */
    private String icCardCode;
    /**
    * 卡种
    */
    private String accountNo;
    /**
    * 支付返回的额外信息
    */
    private String extInfo;


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

    public String getOiltypeCode() {
        return oiltypeCode;
    }

    public void setOiltypeCode(String oiltypeCode) {
        this.oiltypeCode = oiltypeCode;
    }

    public Integer getOilsum() {
        return oilsum;
    }

    public void setOilsum(Integer oilsum) {
        this.oilsum = oilsum;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPaymentNo() {
        return paymentNo;
    }

    public void setPaymentNo(String paymentNo) {
        this.paymentNo = paymentNo;
    }

    public String getPaytoolCode() {
        return paytoolCode;
    }

    public void setPaytoolCode(String paytoolCode) {
        this.paytoolCode = paytoolCode;
    }

    public String getPaytoolName() {
        return paytoolName;
    }

    public void setPaytoolName(String paytoolName) {
        this.paytoolName = paytoolName;
    }

    public String getPaychannelCode() {
        return paychannelCode;
    }

    public void setPaychannelCode(String paychannelCode) {
        this.paychannelCode = paychannelCode;
    }

    public String getPaychannelName() {
        return paychannelName;
    }

    public void setPaychannelName(String paychannelName) {
        this.paychannelName = paychannelName;
    }

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public Integer getPayDiscount() {
        return payDiscount;
    }

    public void setPayDiscount(Integer payDiscount) {
        this.payDiscount = payDiscount;
    }

    public Integer getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Integer paymoney) {
        this.paymoney = paymoney;
    }

    public Integer getArTotal() {
        return arTotal;
    }

    public void setArTotal(Integer arTotal) {
        this.arTotal = arTotal;
    }

    public Integer getArFee() {
        return arFee;
    }

    public void setArFee(Integer arFee) {
        this.arFee = arFee;
    }

    public Integer getUserCash() {
        return userCash;
    }

    public void setUserCash(Integer userCash) {
        this.userCash = userCash;
    }

    public Integer getSettleMoney() {
        return settleMoney;
    }

    public void setSettleMoney(Integer settleMoney) {
        this.settleMoney = settleMoney;
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

    public Integer getRefundPaymoney() {
        return refundPaymoney;
    }

    public void setRefundPaymoney(Integer refundPaymoney) {
        this.refundPaymoney = refundPaymoney;
    }

    public Integer getRefundPayDiscount() {
        return refundPayDiscount;
    }

    public void setRefundPayDiscount(Integer refundPayDiscount) {
        this.refundPayDiscount = refundPayDiscount;
    }

    public Integer getRefundArTotal() {
        return refundArTotal;
    }

    public void setRefundArTotal(Integer refundArTotal) {
        this.refundArTotal = refundArTotal;
    }

    public Integer getRefundArFee() {
        return refundArFee;
    }

    public void setRefundArFee(Integer refundArFee) {
        this.refundArFee = refundArFee;
    }

    public Integer getRefundSettleMoney() {
        return refundSettleMoney;
    }

    public void setRefundSettleMoney(Integer refundSettleMoney) {
        this.refundSettleMoney = refundSettleMoney;
    }

    public Integer getRefundUserCash() {
        return refundUserCash;
    }

    public void setRefundUserCash(Integer refundUserCash) {
        this.refundUserCash = refundUserCash;
    }

    public Integer getRefundTotalFee() {
        return refundTotalFee;
    }

    public void setRefundTotalFee(Integer refundTotalFee) {
        this.refundTotalFee = refundTotalFee;
    }

    public Date getPayDatetime() {
        return payDatetime;
    }

    public void setPayDatetime(Date payDatetime) {
        this.payDatetime = payDatetime;
    }

    public Date getRefundDatetime() {
        return refundDatetime;
    }

    public void setRefundDatetime(Date refundDatetime) {
        this.refundDatetime = refundDatetime;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getIcCardCode() {
        return icCardCode;
    }

    public void setIcCardCode(String icCardCode) {
        this.icCardCode = icCardCode;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

}