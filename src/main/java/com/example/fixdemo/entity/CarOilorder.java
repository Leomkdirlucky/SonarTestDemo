package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 加油记录表
 * </p>
 *
 * @author hongyuan
 * @since 2022-03-04
 */
@TableName("car_oilorder")
@ApiModel(value = "CarOilorder对象", description = "加油记录表")
public class CarOilorder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("中控交易号（第三方）")
    private String thirdId;

    @ApiModelProperty("中控交易号的状态0 成功， -1 失败；（第三方）")
    private Integer thirdStatus;

    @ApiModelProperty("挂枪时候的班次")
    private Integer hangGunShift;

    @ApiModelProperty("班次ID")
    private Integer shiftId;

    @ApiModelProperty("中控中的油品名（第三方）")
    private String posOiltypename;

    @ApiModelProperty("加油日期")
    private String dayid;

    @ApiModelProperty("加油订单号")
    private String orderNo;

    @ApiModelProperty("订单类型")
    private String orderType;

    @ApiModelProperty("交易枪号")
    private Integer gunId;

    @ApiModelProperty("油枪标识")
    private String gunLogo;

    @ApiModelProperty("油枪终端编号")
    private String gunTerminalNo;

    @ApiModelProperty("油枪累计订单数（油机传送）")
    private Integer gunOrdertotal;

    @ApiModelProperty("油枪累计升数油机传送）")
    private Integer gunOilsum;

    @ApiModelProperty("油枪累计金额（油机传送））")
    private Integer gunMoneysum;

    @ApiModelProperty("油品号")
    private Integer oiltypeId;

    @ApiModelProperty("油品编码")
    private String oiltypeCode;

    @ApiModelProperty("油品名称")
    private String oiltypeName;

    @ApiModelProperty("油站价")
    private Integer stationPrice;

    @ApiModelProperty("优惠价格")
    private Integer discountPrice;

    @ApiModelProperty("油机优惠价格（油机传送过来的）")
    private Integer oilDiscountPrice;

    @ApiModelProperty("油量")
    private Integer oilsum;

    @ApiModelProperty("油机金额")
    private Integer totalMoney;

    @ApiModelProperty("油品优惠总金额")
    private Integer discountFee;

    @ApiModelProperty("油品线上优惠金额")
    private Integer onlineDiscountFee;

    @ApiModelProperty("油品线下优惠")
    private Integer offlineDiscountFee;

    @ApiModelProperty("油品总价=油机金额-油品优惠金额")
    private Integer totalFee;

    @ApiModelProperty("状态（0.待收款；1.挂单；2.锁单；3线上锁单；4.收款中；5已收款；6.部分退款；7.撤单）")
    private Integer tradeState;

    private Long startpumpCount;

    private Long endpumpCount;

    @ApiModelProperty("卡号")
    private String cardNo;

    @ApiModelProperty("卡类型")
    private Integer cardType;

    @ApiModelProperty("物理卡号")
    private String physicalCardNo;

    @ApiModelProperty("卡原余额（支付前）")
    private Integer preCardMoney;

    @ApiModelProperty("卡金额")
    private Integer cardMoney;

    @ApiModelProperty("客户编号")
    private String customerNo;

    @ApiModelProperty("交易时间")
    private LocalDateTime tradeTime;

    @ApiModelProperty("添加时间")
    private LocalDateTime addDatetime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateDatetime;

    @ApiModelProperty("提枪时间")
    private LocalDateTime carryGunDatetime;

    @ApiModelProperty("挂枪时间")
    private LocalDateTime handGunDatetime;

    @ApiModelProperty("员工号")
    private String accountId;

    @ApiModelProperty("员工名称")
    private String accountName;

    @ApiModelProperty("授权类型")
    private Integer authType;

    @ApiModelProperty("授权号")
    private String authNo;

    @ApiModelProperty("加油类型")
    private Integer refuelingType;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("发票单号(弃用)")
    private String invoiceNo;

    @ApiModelProperty("发票代号(弃用)")
    private String invoiceCode;

    @ApiModelProperty("税号(弃用)")
    private String invoiceTaxnum;

    @ApiModelProperty("发票抬头(弃用)")
    private String invoiceTitle;

    @ApiModelProperty("开票时间(弃用)")
    private LocalDateTime invoiceDatetime;

    @ApiModelProperty("开票状态(弃用)")
    private Integer invoiceState;

    @ApiModelProperty("退款状态（0，无退款，1部分退款，2撤销）")
    private Integer refundState;

    @ApiModelProperty("退款时间")
    private LocalDateTime refundDatetime;

    @ApiModelProperty("客户端IP")
    private String clientIp;

    @ApiModelProperty("客户端指纹")
    private String clientDevid;

    @ApiModelProperty("打印次数")
    private Integer printTimes;

    @ApiModelProperty("打印更新时间")
    private LocalDateTime printDatetime;

    @ApiModelProperty("预留3")
    private String reserve3;

    @ApiModelProperty("预留4")
    private String reserve4;

    @ApiModelProperty("预留5")
    private String reserve5;

    @ApiModelProperty("预留6")
    private String reserve6;

    @ApiModelProperty("预留7")
    private String reserve7;

    @ApiModelProperty("是否有效（0.无效；1有效）")
    private Integer valid;

    @ApiModelProperty("卡用户名")
    private String cardName;

    @ApiModelProperty("线上更新发票状态时间")
    private LocalDateTime invoiceChagetime;

    @ApiModelProperty("标识1")
    private Integer flag1;

    @ApiModelProperty("标识2")
    private Integer flag2;

    @ApiModelProperty("标识3")
    private Integer flag3;

    @ApiModelProperty("标识4")
    private Integer flag4;

    @ApiModelProperty("卡机联动实体卡支付(1支付失败，2核销失败，4支付中,5支付成功)")
    private Integer cardPayState;

    @ApiModelProperty("发票号")
    private String invoiceGroup;

    @ApiModelProperty("油机优惠金额")
    private Integer oilDiscount;

    @ApiModelProperty("加购状态（0.未加购；1.已加购；2.已撤销）")
    private Integer additonalState;

    @ApiModelProperty("当前交易号")
    private String tradeNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThirdId() {
        return thirdId;
    }

    public void setThirdId(String thirdId) {
        this.thirdId = thirdId;
    }

    public Integer getThirdStatus() {
        return thirdStatus;
    }

    public void setThirdStatus(Integer thirdStatus) {
        this.thirdStatus = thirdStatus;
    }

    public Integer getHangGunShift() {
        return hangGunShift;
    }

    public void setHangGunShift(Integer hangGunShift) {
        this.hangGunShift = hangGunShift;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getPosOiltypename() {
        return posOiltypename;
    }

    public void setPosOiltypename(String posOiltypename) {
        this.posOiltypename = posOiltypename;
    }

    public String getDayid() {
        return dayid;
    }

    public void setDayid(String dayid) {
        this.dayid = dayid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getGunId() {
        return gunId;
    }

    public void setGunId(Integer gunId) {
        this.gunId = gunId;
    }

    public String getGunLogo() {
        return gunLogo;
    }

    public void setGunLogo(String gunLogo) {
        this.gunLogo = gunLogo;
    }

    public String getGunTerminalNo() {
        return gunTerminalNo;
    }

    public void setGunTerminalNo(String gunTerminalNo) {
        this.gunTerminalNo = gunTerminalNo;
    }

    public Integer getGunOrdertotal() {
        return gunOrdertotal;
    }

    public void setGunOrdertotal(Integer gunOrdertotal) {
        this.gunOrdertotal = gunOrdertotal;
    }

    public Integer getGunOilsum() {
        return gunOilsum;
    }

    public void setGunOilsum(Integer gunOilsum) {
        this.gunOilsum = gunOilsum;
    }

    public Integer getGunMoneysum() {
        return gunMoneysum;
    }

    public void setGunMoneysum(Integer gunMoneysum) {
        this.gunMoneysum = gunMoneysum;
    }

    public Integer getOiltypeId() {
        return oiltypeId;
    }

    public void setOiltypeId(Integer oiltypeId) {
        this.oiltypeId = oiltypeId;
    }

    public String getOiltypeCode() {
        return oiltypeCode;
    }

    public void setOiltypeCode(String oiltypeCode) {
        this.oiltypeCode = oiltypeCode;
    }

    public String getOiltypeName() {
        return oiltypeName;
    }

    public void setOiltypeName(String oiltypeName) {
        this.oiltypeName = oiltypeName;
    }

    public Integer getStationPrice() {
        return stationPrice;
    }

    public void setStationPrice(Integer stationPrice) {
        this.stationPrice = stationPrice;
    }

    public Integer getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Integer discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getOilDiscountPrice() {
        return oilDiscountPrice;
    }

    public void setOilDiscountPrice(Integer oilDiscountPrice) {
        this.oilDiscountPrice = oilDiscountPrice;
    }

    public Integer getOilsum() {
        return oilsum;
    }

    public void setOilsum(Integer oilsum) {
        this.oilsum = oilsum;
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

    public Integer getTradeState() {
        return tradeState;
    }

    public void setTradeState(Integer tradeState) {
        this.tradeState = tradeState;
    }

    public Long getStartpumpCount() {
        return startpumpCount;
    }

    public void setStartpumpCount(Long startpumpCount) {
        this.startpumpCount = startpumpCount;
    }

    public Long getEndpumpCount() {
        return endpumpCount;
    }

    public void setEndpumpCount(Long endpumpCount) {
        this.endpumpCount = endpumpCount;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getPhysicalCardNo() {
        return physicalCardNo;
    }

    public void setPhysicalCardNo(String physicalCardNo) {
        this.physicalCardNo = physicalCardNo;
    }

    public Integer getPreCardMoney() {
        return preCardMoney;
    }

    public void setPreCardMoney(Integer preCardMoney) {
        this.preCardMoney = preCardMoney;
    }

    public Integer getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(Integer cardMoney) {
        this.cardMoney = cardMoney;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public LocalDateTime getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(LocalDateTime tradeTime) {
        this.tradeTime = tradeTime;
    }

    public LocalDateTime getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(LocalDateTime addDatetime) {
        this.addDatetime = addDatetime;
    }

    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public LocalDateTime getCarryGunDatetime() {
        return carryGunDatetime;
    }

    public void setCarryGunDatetime(LocalDateTime carryGunDatetime) {
        this.carryGunDatetime = carryGunDatetime;
    }

    public LocalDateTime getHandGunDatetime() {
        return handGunDatetime;
    }

    public void setHandGunDatetime(LocalDateTime handGunDatetime) {
        this.handGunDatetime = handGunDatetime;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getAuthNo() {
        return authNo;
    }

    public void setAuthNo(String authNo) {
        this.authNo = authNo;
    }

    public Integer getRefuelingType() {
        return refuelingType;
    }

    public void setRefuelingType(Integer refuelingType) {
        this.refuelingType = refuelingType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public LocalDateTime getInvoiceDatetime() {
        return invoiceDatetime;
    }

    public void setInvoiceDatetime(LocalDateTime invoiceDatetime) {
        this.invoiceDatetime = invoiceDatetime;
    }

    public Integer getInvoiceState() {
        return invoiceState;
    }

    public void setInvoiceState(Integer invoiceState) {
        this.invoiceState = invoiceState;
    }

    public Integer getRefundState() {
        return refundState;
    }

    public void setRefundState(Integer refundState) {
        this.refundState = refundState;
    }

    public LocalDateTime getRefundDatetime() {
        return refundDatetime;
    }

    public void setRefundDatetime(LocalDateTime refundDatetime) {
        this.refundDatetime = refundDatetime;
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

    public Integer getPrintTimes() {
        return printTimes;
    }

    public void setPrintTimes(Integer printTimes) {
        this.printTimes = printTimes;
    }

    public LocalDateTime getPrintDatetime() {
        return printDatetime;
    }

    public void setPrintDatetime(LocalDateTime printDatetime) {
        this.printDatetime = printDatetime;
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

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public LocalDateTime getInvoiceChagetime() {
        return invoiceChagetime;
    }

    public void setInvoiceChagetime(LocalDateTime invoiceChagetime) {
        this.invoiceChagetime = invoiceChagetime;
    }

    public Integer getFlag1() {
        return flag1;
    }

    public void setFlag1(Integer flag1) {
        this.flag1 = flag1;
    }

    public Integer getFlag2() {
        return flag2;
    }

    public void setFlag2(Integer flag2) {
        this.flag2 = flag2;
    }

    public Integer getFlag3() {
        return flag3;
    }

    public void setFlag3(Integer flag3) {
        this.flag3 = flag3;
    }

    public Integer getFlag4() {
        return flag4;
    }

    public void setFlag4(Integer flag4) {
        this.flag4 = flag4;
    }

    public Integer getCardPayState() {
        return cardPayState;
    }

    public void setCardPayState(Integer cardPayState) {
        this.cardPayState = cardPayState;
    }

    public String getInvoiceGroup() {
        return invoiceGroup;
    }

    public void setInvoiceGroup(String invoiceGroup) {
        this.invoiceGroup = invoiceGroup;
    }

    public Integer getOilDiscount() {
        return oilDiscount;
    }

    public void setOilDiscount(Integer oilDiscount) {
        this.oilDiscount = oilDiscount;
    }

    public Integer getAdditonalState() {
        return additonalState;
    }

    public void setAdditonalState(Integer additonalState) {
        this.additonalState = additonalState;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "CarOilorder{" +
                "id=" + id +
                ", thirdId='" + thirdId + '\'' +
                ", thirdStatus=" + thirdStatus +
                ", hangGunShift=" + hangGunShift +
                ", shiftId=" + shiftId +
                ", posOiltypename='" + posOiltypename + '\'' +
                ", dayid='" + dayid + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderType='" + orderType + '\'' +
                ", gunId=" + gunId +
                ", gunLogo='" + gunLogo + '\'' +
                ", gunTerminalNo='" + gunTerminalNo + '\'' +
                ", gunOrdertotal=" + gunOrdertotal +
                ", gunOilsum=" + gunOilsum +
                ", gunMoneysum=" + gunMoneysum +
                ", oiltypeId=" + oiltypeId +
                ", oiltypeCode='" + oiltypeCode + '\'' +
                ", oiltypeName='" + oiltypeName + '\'' +
                ", stationPrice=" + stationPrice +
                ", discountPrice=" + discountPrice +
                ", oilDiscountPrice=" + oilDiscountPrice +
                ", oilsum=" + oilsum +
                ", totalMoney=" + totalMoney +
                ", discountFee=" + discountFee +
                ", onlineDiscountFee=" + onlineDiscountFee +
                ", offlineDiscountFee=" + offlineDiscountFee +
                ", totalFee=" + totalFee +
                ", tradeState=" + tradeState +
                ", startpumpCount=" + startpumpCount +
                ", endpumpCount=" + endpumpCount +
                ", cardNo='" + cardNo + '\'' +
                ", cardType=" + cardType +
                ", physicalCardNo='" + physicalCardNo + '\'' +
                ", preCardMoney=" + preCardMoney +
                ", cardMoney=" + cardMoney +
                ", customerNo='" + customerNo + '\'' +
                ", tradeTime=" + tradeTime +
                ", addDatetime=" + addDatetime +
                ", updateDatetime=" + updateDatetime +
                ", carryGunDatetime=" + carryGunDatetime +
                ", handGunDatetime=" + handGunDatetime +
                ", accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", authType=" + authType +
                ", authNo='" + authNo + '\'' +
                ", refuelingType=" + refuelingType +
                ", remark='" + remark + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceCode='" + invoiceCode + '\'' +
                ", invoiceTaxnum='" + invoiceTaxnum + '\'' +
                ", invoiceTitle='" + invoiceTitle + '\'' +
                ", invoiceDatetime=" + invoiceDatetime +
                ", invoiceState=" + invoiceState +
                ", refundState=" + refundState +
                ", refundDatetime=" + refundDatetime +
                ", clientIp='" + clientIp + '\'' +
                ", clientDevid='" + clientDevid + '\'' +
                ", printTimes=" + printTimes +
                ", printDatetime=" + printDatetime +
                ", reserve3='" + reserve3 + '\'' +
                ", reserve4='" + reserve4 + '\'' +
                ", reserve5='" + reserve5 + '\'' +
                ", reserve6='" + reserve6 + '\'' +
                ", reserve7='" + reserve7 + '\'' +
                ", valid=" + valid +
                ", cardName='" + cardName + '\'' +
                ", invoiceChagetime=" + invoiceChagetime +
                ", flag1=" + flag1 +
                ", flag2=" + flag2 +
                ", flag3=" + flag3 +
                ", flag4=" + flag4 +
                ", cardPayState=" + cardPayState +
                ", invoiceGroup='" + invoiceGroup + '\'' +
                ", oilDiscount=" + oilDiscount +
                ", additonalState=" + additonalState +
                ", tradeNo=" + tradeNo +
                '}';
    }
}
