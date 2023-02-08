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
 * 主班次表
 * </p>
 *
 * @author laoyj
 * @since 2022-04-04
 */
@TableName("car_shiftcount")
@ApiModel(value = "CarShiftcount对象", description = "主班次表")
public class CarShiftcount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer stationId;

    @ApiModelProperty("天id")
    private Integer dayid;

    @ApiModelProperty("跨天班次天id")
    private Integer changeDayid;

    @ApiModelProperty("班次id")
    private Integer classId;

    @ApiModelProperty("员工组id")
    private Integer groupId;

    @ApiModelProperty("油枪泵码表快照ID")
    private Integer snapshootGunId;

    @ApiModelProperty("油枪液位仪快照ID")
    private Integer snapshootTankId;

    @ApiModelProperty("销售交易笔数")
    private Integer salecount;

    @ApiModelProperty("销售油量（0.01升）")
    private Integer saleoilsum;

    @ApiModelProperty("销售商品数量")
    private Integer salegoodsum;

    @ApiModelProperty("便利店原总价金额")
    private Integer goodsTotalMoney;

    @ApiModelProperty("便利店优惠金额")
    private Integer goodsDiscountFee;

    @ApiModelProperty("便利店线上优惠金额")
    private Integer goodsOnlineDiscountFee;

    @ApiModelProperty("便利店线下优惠金额")
    private Integer goodsOfflineDiscountFee;

    @ApiModelProperty("便利店赠品成本")
    private Integer goodsGiftCost;

    @ApiModelProperty("便利店总价金额")
    private Integer goodsTotalFee;

    @ApiModelProperty("油品原总价金额")
    private Integer oilTotalMoney;

    @ApiModelProperty("油品优惠金额")
    private Integer oilDiscountFee;

    @ApiModelProperty("油品线上优惠金额")
    private Integer oilOnlineDiscountFee;

    @ApiModelProperty("油品线下优惠金额")
    private Integer oilOfflineDiscountFee;

    @ApiModelProperty("油品总价金额")
    private Integer oilTotalFee;

    @ApiModelProperty("油机优惠金额")
    private Integer oilengineMoney;

    @ApiModelProperty("商品原总价优惠")
    private Integer totalMoney;

    @ApiModelProperty("商品优惠金额")
    private Integer discountFee;

    @ApiModelProperty("商品总价金额")
    private Integer totalFee;

    @ApiModelProperty("实付金额（分）=商品总价金额-支付优惠额")
    private Integer paymoney;

    @ApiModelProperty("支付优惠额")
    private Integer payDiscount;

    @ApiModelProperty("结算金额")
    private Integer arTotal;

    @ApiModelProperty("手续费")
    private Integer arFee;

    @ApiModelProperty("应收款")
    private Integer settleMoney;

    @ApiModelProperty("用户实际付款")
    private Integer userCash;

    @ApiModelProperty("退款笔数")
    private Integer refundSalecount;

    @ApiModelProperty("退款油量")
    private Integer refundSaleoilsum;

    @ApiModelProperty("便利店退款数量")
    private Integer refundSalegoodsum;

    @ApiModelProperty("退款便利店原总价金额")
    private Integer refundGoodsTotalMoney;

    @ApiModelProperty("退款便利店优惠额")
    private Integer refundGoodsDiscountFee;

    @ApiModelProperty("退款便利店线上优惠额")
    private Integer refundGoodsOnlineDiscountFee;

    @ApiModelProperty("退款便利店线下订单优惠额")
    private Integer refundGoodsOfflineDiscountFee;

    @ApiModelProperty("退款便利店总价金额")
    private Integer refundGoodsTotalFee;

    @ApiModelProperty("退款便利店赠品成本")
    private Integer refundGoodsGiftCost;

    @ApiModelProperty("退款油品原总价金额")
    private Integer refundOilTotalMoney;

    @ApiModelProperty("退款油品订单优惠额")
    private Integer refundOilDiscountFee;

    @ApiModelProperty("退款油品订单线上优惠额")
    private Integer refundOilOnlineDiscountFee;

    @ApiModelProperty("退款油品线下订单优惠额")
    private Integer refundOilOfflineDiscountFee;

    @ApiModelProperty("退款油品总价金额")
    private Integer refundOilTotalFee;

    @ApiModelProperty("退款商品原金额")
    private Integer refundTotalMoney;

    @ApiModelProperty("退款商品优惠金额")
    private Integer refundDiscountFee;

    @ApiModelProperty("退款商品总价金额")
    private Integer refundTotalFee;

    @ApiModelProperty("退款支付优惠额")
    private Integer refundPayDiscount;

    @ApiModelProperty("退款实付额=退款商品原总价金额-退款商品优惠额")
    private Integer refundPaymoney;

    @ApiModelProperty("退款应收额=退款实付额-退款支付优惠额")
    private Integer refundArTotal;

    @ApiModelProperty("结存退油量")
    private Integer refundSurplusoilsum;

    @ApiModelProperty("手续费")
    private Integer refundArFee;

    @ApiModelProperty("应收款金额")
    private Integer refundSettleMoney;

    @ApiModelProperty("用户实际金额")
    private Integer refundUserCash;

    @ApiModelProperty("本期付出")
    private Integer paytotal;

    @ApiModelProperty("库存调整（0.01升）")
    private Integer adjustoilsum;

    @ApiModelProperty("本期结存油量（0.01升）")
    private Integer surplusoilsum;

    @ApiModelProperty("本期实存油量（0.01升）")
    private Integer actualoilsum;

    @ApiModelProperty("盈亏（分）")
    private Integer profitLoss;

    @ApiModelProperty("是否已结算：0.未结算；1：已结算")
    private Integer isSettle;

    @ApiModelProperty("操作人")
    private String operator;

    @ApiModelProperty("班次确认收银员")
    private String checker;

    @ApiModelProperty("交班结算备注")
    private String checkRemark;

    @ApiModelProperty("运作日志")
    private String operationLog;

    @ApiModelProperty("班次开始时间")
    private LocalDateTime addDatetime;

    @ApiModelProperty("结算时间")
    private LocalDateTime settleDatetime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateDatetime;

    @ApiModelProperty("投款金额")
    private Long investmentMoney;

    @ApiModelProperty("现金清点")
    private Integer inventoryMoney;

    @ApiModelProperty("充值金额")
    private Long rechargeMoney;

    @ApiModelProperty("班次结束时间")
    private LocalDateTime endDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getDayid() {
        return dayid;
    }

    public void setDayid(Integer dayid) {
        this.dayid = dayid;
    }
    public Integer getChangeDayid() {
        return changeDayid;
    }

    public void setChangeDayid(Integer changeDayid) {
        this.changeDayid = changeDayid;
    }
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
    public Integer getSnapshootGunId() {
        return snapshootGunId;
    }

    public void setSnapshootGunId(Integer snapshootGunId) {
        this.snapshootGunId = snapshootGunId;
    }
    public Integer getSnapshootTankId() {
        return snapshootTankId;
    }

    public void setSnapshootTankId(Integer snapshootTankId) {
        this.snapshootTankId = snapshootTankId;
    }
    public Integer getSalecount() {
        return salecount;
    }

    public void setSalecount(Integer salecount) {
        this.salecount = salecount;
    }
    public Integer getSaleoilsum() {
        return saleoilsum;
    }

    public void setSaleoilsum(Integer saleoilsum) {
        this.saleoilsum = saleoilsum;
    }
    public Integer getSalegoodsum() {
        return salegoodsum;
    }

    public void setSalegoodsum(Integer salegoodsum) {
        this.salegoodsum = salegoodsum;
    }
    public Integer getGoodsTotalMoney() {
        return goodsTotalMoney;
    }

    public void setGoodsTotalMoney(Integer goodsTotalMoney) {
        this.goodsTotalMoney = goodsTotalMoney;
    }
    public Integer getGoodsDiscountFee() {
        return goodsDiscountFee;
    }

    public void setGoodsDiscountFee(Integer goodsDiscountFee) {
        this.goodsDiscountFee = goodsDiscountFee;
    }
    public Integer getGoodsOnlineDiscountFee() {
        return goodsOnlineDiscountFee;
    }

    public void setGoodsOnlineDiscountFee(Integer goodsOnlineDiscountFee) {
        this.goodsOnlineDiscountFee = goodsOnlineDiscountFee;
    }
    public Integer getGoodsOfflineDiscountFee() {
        return goodsOfflineDiscountFee;
    }

    public void setGoodsOfflineDiscountFee(Integer goodsOfflineDiscountFee) {
        this.goodsOfflineDiscountFee = goodsOfflineDiscountFee;
    }
    public Integer getGoodsGiftCost() {
        return goodsGiftCost;
    }

    public void setGoodsGiftCost(Integer goodsGiftCost) {
        this.goodsGiftCost = goodsGiftCost;
    }
    public Integer getGoodsTotalFee() {
        return goodsTotalFee;
    }

    public void setGoodsTotalFee(Integer goodsTotalFee) {
        this.goodsTotalFee = goodsTotalFee;
    }
    public Integer getOilTotalMoney() {
        return oilTotalMoney;
    }

    public void setOilTotalMoney(Integer oilTotalMoney) {
        this.oilTotalMoney = oilTotalMoney;
    }
    public Integer getOilDiscountFee() {
        return oilDiscountFee;
    }

    public void setOilDiscountFee(Integer oilDiscountFee) {
        this.oilDiscountFee = oilDiscountFee;
    }
    public Integer getOilOnlineDiscountFee() {
        return oilOnlineDiscountFee;
    }

    public void setOilOnlineDiscountFee(Integer oilOnlineDiscountFee) {
        this.oilOnlineDiscountFee = oilOnlineDiscountFee;
    }
    public Integer getOilOfflineDiscountFee() {
        return oilOfflineDiscountFee;
    }

    public void setOilOfflineDiscountFee(Integer oilOfflineDiscountFee) {
        this.oilOfflineDiscountFee = oilOfflineDiscountFee;
    }
    public Integer getOilTotalFee() {
        return oilTotalFee;
    }

    public void setOilTotalFee(Integer oilTotalFee) {
        this.oilTotalFee = oilTotalFee;
    }
    public Integer getOilengineMoney() {
        return oilengineMoney;
    }

    public void setOilengineMoney(Integer oilengineMoney) {
        this.oilengineMoney = oilengineMoney;
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
    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }
    public Integer getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Integer paymoney) {
        this.paymoney = paymoney;
    }
    public Integer getPayDiscount() {
        return payDiscount;
    }

    public void setPayDiscount(Integer payDiscount) {
        this.payDiscount = payDiscount;
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
    public Integer getRefundSalecount() {
        return refundSalecount;
    }

    public void setRefundSalecount(Integer refundSalecount) {
        this.refundSalecount = refundSalecount;
    }
    public Integer getRefundSaleoilsum() {
        return refundSaleoilsum;
    }

    public void setRefundSaleoilsum(Integer refundSaleoilsum) {
        this.refundSaleoilsum = refundSaleoilsum;
    }
    public Integer getRefundSalegoodsum() {
        return refundSalegoodsum;
    }

    public void setRefundSalegoodsum(Integer refundSalegoodsum) {
        this.refundSalegoodsum = refundSalegoodsum;
    }
    public Integer getRefundGoodsTotalMoney() {
        return refundGoodsTotalMoney;
    }

    public void setRefundGoodsTotalMoney(Integer refundGoodsTotalMoney) {
        this.refundGoodsTotalMoney = refundGoodsTotalMoney;
    }
    public Integer getRefundGoodsDiscountFee() {
        return refundGoodsDiscountFee;
    }

    public void setRefundGoodsDiscountFee(Integer refundGoodsDiscountFee) {
        this.refundGoodsDiscountFee = refundGoodsDiscountFee;
    }
    public Integer getRefundGoodsOnlineDiscountFee() {
        return refundGoodsOnlineDiscountFee;
    }

    public void setRefundGoodsOnlineDiscountFee(Integer refundGoodsOnlineDiscountFee) {
        this.refundGoodsOnlineDiscountFee = refundGoodsOnlineDiscountFee;
    }
    public Integer getRefundGoodsOfflineDiscountFee() {
        return refundGoodsOfflineDiscountFee;
    }

    public void setRefundGoodsOfflineDiscountFee(Integer refundGoodsOfflineDiscountFee) {
        this.refundGoodsOfflineDiscountFee = refundGoodsOfflineDiscountFee;
    }
    public Integer getRefundGoodsTotalFee() {
        return refundGoodsTotalFee;
    }

    public void setRefundGoodsTotalFee(Integer refundGoodsTotalFee) {
        this.refundGoodsTotalFee = refundGoodsTotalFee;
    }
    public Integer getRefundGoodsGiftCost() {
        return refundGoodsGiftCost;
    }

    public void setRefundGoodsGiftCost(Integer refundGoodsGiftCost) {
        this.refundGoodsGiftCost = refundGoodsGiftCost;
    }
    public Integer getRefundOilTotalMoney() {
        return refundOilTotalMoney;
    }

    public void setRefundOilTotalMoney(Integer refundOilTotalMoney) {
        this.refundOilTotalMoney = refundOilTotalMoney;
    }
    public Integer getRefundOilDiscountFee() {
        return refundOilDiscountFee;
    }

    public void setRefundOilDiscountFee(Integer refundOilDiscountFee) {
        this.refundOilDiscountFee = refundOilDiscountFee;
    }
    public Integer getRefundOilOnlineDiscountFee() {
        return refundOilOnlineDiscountFee;
    }

    public void setRefundOilOnlineDiscountFee(Integer refundOilOnlineDiscountFee) {
        this.refundOilOnlineDiscountFee = refundOilOnlineDiscountFee;
    }
    public Integer getRefundOilOfflineDiscountFee() {
        return refundOilOfflineDiscountFee;
    }

    public void setRefundOilOfflineDiscountFee(Integer refundOilOfflineDiscountFee) {
        this.refundOilOfflineDiscountFee = refundOilOfflineDiscountFee;
    }
    public Integer getRefundOilTotalFee() {
        return refundOilTotalFee;
    }

    public void setRefundOilTotalFee(Integer refundOilTotalFee) {
        this.refundOilTotalFee = refundOilTotalFee;
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
    public Integer getRefundTotalFee() {
        return refundTotalFee;
    }

    public void setRefundTotalFee(Integer refundTotalFee) {
        this.refundTotalFee = refundTotalFee;
    }
    public Integer getRefundPayDiscount() {
        return refundPayDiscount;
    }

    public void setRefundPayDiscount(Integer refundPayDiscount) {
        this.refundPayDiscount = refundPayDiscount;
    }
    public Integer getRefundPaymoney() {
        return refundPaymoney;
    }

    public void setRefundPaymoney(Integer refundPaymoney) {
        this.refundPaymoney = refundPaymoney;
    }
    public Integer getRefundArTotal() {
        return refundArTotal;
    }

    public void setRefundArTotal(Integer refundArTotal) {
        this.refundArTotal = refundArTotal;
    }
    public Integer getRefundSurplusoilsum() {
        return refundSurplusoilsum;
    }

    public void setRefundSurplusoilsum(Integer refundSurplusoilsum) {
        this.refundSurplusoilsum = refundSurplusoilsum;
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
    public Integer getPaytotal() {
        return paytotal;
    }

    public void setPaytotal(Integer paytotal) {
        this.paytotal = paytotal;
    }
    public Integer getAdjustoilsum() {
        return adjustoilsum;
    }

    public void setAdjustoilsum(Integer adjustoilsum) {
        this.adjustoilsum = adjustoilsum;
    }
    public Integer getSurplusoilsum() {
        return surplusoilsum;
    }

    public void setSurplusoilsum(Integer surplusoilsum) {
        this.surplusoilsum = surplusoilsum;
    }
    public Integer getActualoilsum() {
        return actualoilsum;
    }

    public void setActualoilsum(Integer actualoilsum) {
        this.actualoilsum = actualoilsum;
    }
    public Integer getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(Integer profitLoss) {
        this.profitLoss = profitLoss;
    }
    public Integer getIsSettle() {
        return isSettle;
    }

    public void setIsSettle(Integer isSettle) {
        this.isSettle = isSettle;
    }
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }
    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }
    public String getOperationLog() {
        return operationLog;
    }

    public void setOperationLog(String operationLog) {
        this.operationLog = operationLog;
    }
    public LocalDateTime getAddDatetime() {
        return addDatetime;
    }

    public void setAddDatetime(LocalDateTime addDatetime) {
        this.addDatetime = addDatetime;
    }
    public LocalDateTime getSettleDatetime() {
        return settleDatetime;
    }

    public void setSettleDatetime(LocalDateTime settleDatetime) {
        this.settleDatetime = settleDatetime;
    }
    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
    public Long getInvestmentMoney() {
        return investmentMoney;
    }

    public void setInvestmentMoney(Long investmentMoney) {
        this.investmentMoney = investmentMoney;
    }
    public Integer getInventoryMoney() {
        return inventoryMoney;
    }

    public void setInventoryMoney(Integer inventoryMoney) {
        this.inventoryMoney = inventoryMoney;
    }
    public Long getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(Long rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }
    public LocalDateTime getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(LocalDateTime endDatetime) {
        this.endDatetime = endDatetime;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "CarShiftcount{" +
            "id=" + id +
            ", dayid=" + dayid +
            ", changeDayid=" + changeDayid +
            ", classId=" + classId +
            ", groupId=" + groupId +
            ", snapshootGunId=" + snapshootGunId +
            ", snapshootTankId=" + snapshootTankId +
            ", salecount=" + salecount +
            ", saleoilsum=" + saleoilsum +
            ", salegoodsum=" + salegoodsum +
            ", goodsTotalMoney=" + goodsTotalMoney +
            ", goodsDiscountFee=" + goodsDiscountFee +
            ", goodsOnlineDiscountFee=" + goodsOnlineDiscountFee +
            ", goodsOfflineDiscountFee=" + goodsOfflineDiscountFee +
            ", goodsGiftCost=" + goodsGiftCost +
            ", goodsTotalFee=" + goodsTotalFee +
            ", oilTotalMoney=" + oilTotalMoney +
            ", oilDiscountFee=" + oilDiscountFee +
            ", oilOnlineDiscountFee=" + oilOnlineDiscountFee +
            ", oilOfflineDiscountFee=" + oilOfflineDiscountFee +
            ", oilTotalFee=" + oilTotalFee +
            ", oilengineMoney=" + oilengineMoney +
            ", totalMoney=" + totalMoney +
            ", discountFee=" + discountFee +
            ", totalFee=" + totalFee +
            ", paymoney=" + paymoney +
            ", payDiscount=" + payDiscount +
            ", arTotal=" + arTotal +
            ", arFee=" + arFee +
            ", settleMoney=" + settleMoney +
            ", userCash=" + userCash +
            ", refundSalecount=" + refundSalecount +
            ", refundSaleoilsum=" + refundSaleoilsum +
            ", refundSalegoodsum=" + refundSalegoodsum +
            ", refundGoodsTotalMoney=" + refundGoodsTotalMoney +
            ", refundGoodsDiscountFee=" + refundGoodsDiscountFee +
            ", refundGoodsOnlineDiscountFee=" + refundGoodsOnlineDiscountFee +
            ", refundGoodsOfflineDiscountFee=" + refundGoodsOfflineDiscountFee +
            ", refundGoodsTotalFee=" + refundGoodsTotalFee +
            ", refundGoodsGiftCost=" + refundGoodsGiftCost +
            ", refundOilTotalMoney=" + refundOilTotalMoney +
            ", refundOilDiscountFee=" + refundOilDiscountFee +
            ", refundOilOnlineDiscountFee=" + refundOilOnlineDiscountFee +
            ", refundOilOfflineDiscountFee=" + refundOilOfflineDiscountFee +
            ", refundOilTotalFee=" + refundOilTotalFee +
            ", refundTotalMoney=" + refundTotalMoney +
            ", refundDiscountFee=" + refundDiscountFee +
            ", refundTotalFee=" + refundTotalFee +
            ", refundPayDiscount=" + refundPayDiscount +
            ", refundPaymoney=" + refundPaymoney +
            ", refundArTotal=" + refundArTotal +
            ", refundSurplusoilsum=" + refundSurplusoilsum +
            ", refundArFee=" + refundArFee +
            ", refundSettleMoney=" + refundSettleMoney +
            ", refundUserCash=" + refundUserCash +
            ", paytotal=" + paytotal +
            ", adjustoilsum=" + adjustoilsum +
            ", surplusoilsum=" + surplusoilsum +
            ", actualoilsum=" + actualoilsum +
            ", profitLoss=" + profitLoss +
            ", isSettle=" + isSettle +
            ", operator=" + operator +
            ", checker=" + checker +
            ", checkRemark=" + checkRemark +
            ", operationLog=" + operationLog +
            ", addDatetime=" + addDatetime +
            ", settleDatetime=" + settleDatetime +
            ", updateDatetime=" + updateDatetime +
            ", investmentMoney=" + investmentMoney +
            ", inventoryMoney=" + inventoryMoney +
            ", rechargeMoney=" + rechargeMoney +
            ", endDatetime=" + endDatetime +
        "}";
    }
}
