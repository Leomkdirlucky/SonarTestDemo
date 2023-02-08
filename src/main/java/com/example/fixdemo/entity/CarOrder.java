package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 交易总表(CarOrder)实体类
 *
 * @author makejava
 * @since 2021-10-12 17:01:36
 */
public class CarOrder implements Serializable {
    private static final long serialVersionUID = -75174485528061453L;
    /**
    * 自增id
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 交易日期
    */
    private String dayid;
    /**
    * 班次id
    */
    private Integer shiftId;
    /**
    * 交易总订单号
    */
    private String tradeNo;
    /**
    * 交易状态（0.待收款；1.挂单；2.锁单；3.交易确认中；4.部分收款；5.已收款；6.部分退款；7.撤单；8.已关闭；9.退款中）
    */
    private Object tradeState;
    /**
    * 商品原总价金额
    */
    private Integer totalMoney;
    /**
    * 商品优惠金额
    */
    private Integer discountFee;
    /**
    * 商品线上优惠金额
    */
    private Integer onlineDiscountFee;
    /**
    * 商品线下优惠金额
    */
    private Integer offlineDiscountFee;
    /**
    * 商品总价金额=商品原总价金额-商品优惠额
    */
    private Integer totalFee;
    /**
    * 订单数量
    */
    private Integer totalCount;
    /**
    * 交易优惠额
    */
    private Integer payDiscount;
    /**
    * 实收额=商品总价金额-支付优惠额
    */
    private Integer paymoney;
    /**
    * 应到账=实收额-手续费
    */
    private Integer settleMoney;
    /**
    * 用户实际支付
    */
    private Integer userCash;
    /**
    * 手续费
    */
    private Integer arFee;
    /**
    * 结算额(实付额与平台后结得出)
    */
    private Integer arTotal;
    /**
    * 累计实付金额
    */
    private Integer paymoneySum;
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
    /**
    * 退款累计商品总价金额
    */
    private Integer refundTotalFee;
    /**
    * 退款累计实付额
    */
    private Integer refundPaymoney;
    /**
    * 退款累计支付优惠金额
    */
    private Integer refundPayDiscount;
    /**
    * 退款累计用户实际付款
    */
    private Integer refundUserCash;
    /**
    * 退款累计手续费
    */
    private Integer refundArFee;
    /**
    * 退款累计结算金额
    */
    private Integer refundArTotal;
    /**
    * 退款累计应结算金额
    */
    private Integer refundSettleMoney;
    /**
    * 退款次数
    */
    private Integer refundTimes;
    /**
    * 退款状态（0无退款，1部分退款，2撤销）
    */
    private Integer refundState;
    /**
    * 是否需要发票 0.不需要；1.开票
    */
    private Integer needbill;
    /**
    * 发票单号
    */
    private String invoiceNo;
    /**
    * 发票状态（0.未开票；1.部分开票；2.已全部开票）
    */
    private Object invoiceState;
    /**
    * 发票抬头
    */
    private String invoiceTitle;
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
    * 订单类型（1.油品；2.便利店；3.充值；4.混合）
    */
    private Object orderType;
    /**
    * 预留2
    */
    private String reserve2;
    /**
    * 预留3
    */
    private String reserve3;
    /**
    * 预留4
    */
    private String reserve4;
    /**
    * 预留5
    */
    private String reserve5;
    /**
    * 预留6
    */
    private String reserve6;
    /**
    * 预留7
    */
    private String reserve7;
    /**
    * 最后一次退款时间
    */
    private Date lastRefundDatetime;
    /**
    * 积分抵扣金额
    */
    private Integer bonusAmount;
    /**
    * 是否有效（0无效；1有效）
    */
    private Object valid;
    /**
    * 操作人
    */
    private String operator;
    /**
    * 消费是否可积分（0.不可积分；1.积分）
    */
    private Object bonusType;
    /**
    * 下单前积分值
    */
    private Integer beforeBonus;
    /**
    * ic卡登陆信息
    */
    private String icLoginInfo;
    /**
    * 微信会员卡信息
    */
    private String membercardInfo;
    /**
    * 本单积分
    */
    private Integer bonus;
    /**
    * 芝麻ID
    */
    private String zhimaid;
    /**
    * 订单来源：0内场核销，1外场核销
    */
    private Object orderSource;
    /**
    * 外场核销状态：0外场核销，1完全核销
    */
    private Object outfieldState;
    /**
     * 加购记录
     */
    private String additionalOrder;
    /**
     * 加购状态（0.未加购；1.已加购；2.已撤销）
     */
    private Object additonalState;
    /**
     * 0待发放，1发放中，2已发放，3已超时，即自提交时间起算，超过当前配置的有效时间后 4：已失效，即用户发放失败 5：已失效，即用户退款 6：已失效，即用户凭证被人工置为失效
     */
    private Integer distributeBonusStatus;

    public Integer getDistributeBonusStatus() {
        return distributeBonusStatus;
    }

    public void setDistributeBonusStatus(Integer distributeBonusStatus) {
        this.distributeBonusStatus = distributeBonusStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDayid() {
        return dayid;
    }

    public void setDayid(String dayid) {
        this.dayid = dayid;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
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

    public Integer getSettleMoney() {
        return settleMoney;
    }

    public void setSettleMoney(Integer settleMoney) {
        this.settleMoney = settleMoney;
    }

    public Integer getUserCash() {
        return userCash;
    }

    public void setUserCash(Integer userCash) {
        this.userCash = userCash;
    }

    public Integer getArFee() {
        return arFee;
    }

    public void setArFee(Integer arFee) {
        this.arFee = arFee;
    }

    public Integer getArTotal() {
        return arTotal;
    }

    public void setArTotal(Integer arTotal) {
        this.arTotal = arTotal;
    }

    public Integer getPaymoneySum() {
        return paymoneySum;
    }

    public void setPaymoneySum(Integer paymoneySum) {
        this.paymoneySum = paymoneySum;
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

    public Integer getRefundUserCash() {
        return refundUserCash;
    }

    public void setRefundUserCash(Integer refundUserCash) {
        this.refundUserCash = refundUserCash;
    }

    public Integer getRefundArFee() {
        return refundArFee;
    }

    public void setRefundArFee(Integer refundArFee) {
        this.refundArFee = refundArFee;
    }

    public Integer getRefundArTotal() {
        return refundArTotal;
    }

    public void setRefundArTotal(Integer refundArTotal) {
        this.refundArTotal = refundArTotal;
    }

    public Integer getRefundSettleMoney() {
        return refundSettleMoney;
    }

    public void setRefundSettleMoney(Integer refundSettleMoney) {
        this.refundSettleMoney = refundSettleMoney;
    }

    public Integer getRefundTimes() {
        return refundTimes;
    }

    public void setRefundTimes(Integer refundTimes) {
        this.refundTimes = refundTimes;
    }

    public Integer getRefundState() {
        return refundState;
    }

    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }

    public Integer getNeedbill() {
        return needbill;
    }

    public void setNeedbill(Integer needbill) {
        this.needbill = needbill;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Object getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(Object invoiceState) {
        this.invoiceState = invoiceState;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
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

    public Object getOrderType() {
        return orderType;
    }

    public void setOrderType(Object orderType) {
        this.orderType = orderType;
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2;
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3;
    }

    public String getReserve4() {
        return reserve4;
    }

    public void setReserve4(String reserve4) {
        this.reserve4 = reserve4;
    }

    public String getReserve5() {
        return reserve5;
    }

    public void setReserve5(String reserve5) {
        this.reserve5 = reserve5;
    }

    public String getReserve6() {
        return reserve6;
    }

    public void setReserve6(String reserve6) {
        this.reserve6 = reserve6;
    }

    public String getReserve7() {
        return reserve7;
    }

    public void setReserve7(String reserve7) {
        this.reserve7 = reserve7;
    }

    public Date getLastRefundDatetime() {
        return lastRefundDatetime;
    }

    public void setLastRefundDatetime(Date lastRefundDatetime) {
        this.lastRefundDatetime = lastRefundDatetime;
    }

    public Integer getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(Integer bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getBonusType() {
        return bonusType;
    }

    public void setBonusType(Object bonusType) {
        this.bonusType = bonusType;
    }

    public Integer getBeforeBonus() {
        return beforeBonus;
    }

    public void setBeforeBonus(Integer beforeBonus) {
        this.beforeBonus = beforeBonus;
    }

    public String getIcLoginInfo() {
        return icLoginInfo;
    }

    public void setIcLoginInfo(String icLoginInfo) {
        this.icLoginInfo = icLoginInfo;
    }

    public String getMembercardInfo() {
        return membercardInfo;
    }

    public void setMembercardInfo(String membercardInfo) {
        this.membercardInfo = membercardInfo;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getZhimaid() {
        return zhimaid;
    }

    public void setZhimaid(String zhimaid) {
        this.zhimaid = zhimaid;
    }

    public Object getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Object orderSource) {
        this.orderSource = orderSource;
    }

    public Object getOutfieldState() {
        return outfieldState;
    }

    public void setOutfieldState(Object outfieldState) {
        this.outfieldState = outfieldState;
    }

    public String getAdditionalOrder() {
        return additionalOrder;
    }

    public void setAdditionalOrder(String additionalOrder) {
        this.additionalOrder = additionalOrder;
    }

    public Object getAdditonalState() {
        return additonalState;
    }

    public void setAdditonalState(Object additonalState) {
        this.additonalState = additonalState;
    }
}