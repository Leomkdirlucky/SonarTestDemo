package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 积分发放表(CarBonusRecord)实体类
 *
 * @author makejava
 * @since 2021-10-29 11:17:09
 */
public class CarBonusRecord implements Serializable {
    private static final long serialVersionUID = 500130622989173164L;
    /**
    * 自增ID
    */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
    * 班次ID
    */
    private Integer shiftId;
    /**
    * 卡种
    */
    private String accountNo;
    /**
    * 客户名称
    */
    private String accountName;
    /**
    * 钱包账户
    */
    private String userId;
    /**
    * 用户名称
    */
    private String userName;
    /**
    * 积分账户
    */
    private String pointsId;
    /**
    * 用户积分账户
    */
    private String userCode;
    /**
    * 积分发放单号
    */
    private String orderNo;
    /**
    * 0.系统自动发放；1.交易订单发放；2.人工发放；3.手工积分发放；4，油品订单积分补发；5，发放微信积分
    */
    private Object orderType;
    /**
    * 交易总表号
    */
    private String tradeNo;
    /**
    * 芝麻发放单号
    */
    private String zmTradeNo;
    /**
    * 发放积分
    */
    private Integer totalBonus;
    /**
    * 发放后积分
    */
    private Integer afterTotalBonus;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;
    /**
    * 发放状态（0.待发放；1.已发放；2.发放失败；3.发放超时；4.部分退积分；5.积分撤单）
    */
    private Object tradeState;
    /**
    * 累计退积分
    */
    private Integer refundBonus;
    /**
    * 操作者
    */
    private String operator;
    /**
    * 额外信息
    */
    private String extInfo;
    /**
    * 设备号
    */
    private String clientDevid;
    /**
    * 设备IP
    */
    private String clientIp;
    /**
    * 备注
    */
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getShiftId() {
        return shiftId;
    }

    public void setShiftId(Integer shiftId) {
        this.shiftId = shiftId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPointsId() {
        return pointsId;
    }

    public void setPointsId(String pointsId) {
        this.pointsId = pointsId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getZmTradeNo() {
        return zmTradeNo;
    }

    public void setZmTradeNo(String zmTradeNo) {
        this.zmTradeNo = zmTradeNo;
    }

    public Integer getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(Integer totalBonus) {
        this.totalBonus = totalBonus;
    }

    public Integer getAfterTotalBonus() {
        return afterTotalBonus;
    }

    public void setAfterTotalBonus(Integer afterTotalBonus) {
        this.afterTotalBonus = afterTotalBonus;
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

    public Object getTradeState() {
        return tradeState;
    }

    public void setTradeState(Object tradeState) {
        this.tradeState = tradeState;
    }

    public Integer getRefundBonus() {
        return refundBonus;
    }

    public void setRefundBonus(Integer refundBonus) {
        this.refundBonus = refundBonus;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getExtInfo() {
        return extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public String getClientDevid() {
        return clientDevid;
    }

    public void setClientDevid(String clientDevid) {
        this.clientDevid = clientDevid;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}