package com.example.fixdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 支付工具表(CarPaytool)实体类
 *
 * @author makejava
 * @since 2021-10-27 11:18:29
 */
public class CarPaytool implements Serializable {
    private static final long serialVersionUID = -48478179823004373L;
    /**
    * 序号
    */
    private Integer id;
    /**
    * 支付工具编码
    */
    private String paytoolCode;
    /**
    * 默认类型（0.不选中;1.选中)
    */
    private Object paytoolType;
    /**
    * 支付工具名称
    */
    private String paytoolName;
    /**
    * 0为默认支付工具 1-用户自定义创建
    */
    private Object isDefault;
    /**
    * 是否网络支付（0，线下支付；1线上支付）
    */
    private Object isNetpay;
    /**
    * 是否在报表实收中展示
    */
    private Object isShowGains;
    /**
    * 班次统计是否可手动录入（0.否，1是）
    */
    private Object manualInput;
    /**
    * 是否有效（0.无效；1有效）
    */
    private Object valid;
    /**
    * 添加时间
    */
    private Date addTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 商家联是否自动打印小票（0否，1是）
    */
    private Object isPrint;
    /**
    * 出票数
    */
    private Integer ticketCount;
    /**
    * 芝麻系统支付工具代码(ALIPAY;WEIXIN;CASH;BANKCARD;TRANSFER;CHEQUE;OLDCARDAUTOTRANSFER)
    */
    private String zmPaytoolCode;
    /**
    * 芝麻系统支付工具名称（微信、支付宝、现金、银行卡;银行卡转账;支票；旧卡迁移）
    */
    private String zmPaytoolName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPaytoolCode() {
        return paytoolCode;
    }

    public void setPaytoolCode(String paytoolCode) {
        this.paytoolCode = paytoolCode;
    }

    public Object getPaytoolType() {
        return paytoolType;
    }

    public void setPaytoolType(Object paytoolType) {
        this.paytoolType = paytoolType;
    }

    public String getPaytoolName() {
        return paytoolName;
    }

    public void setPaytoolName(String paytoolName) {
        this.paytoolName = paytoolName;
    }

    public Object getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Object isDefault) {
        this.isDefault = isDefault;
    }

    public Object getIsNetpay() {
        return isNetpay;
    }

    public void setIsNetpay(Object isNetpay) {
        this.isNetpay = isNetpay;
    }

    public Object getIsShowGains() {
        return isShowGains;
    }

    public void setIsShowGains(Object isShowGains) {
        this.isShowGains = isShowGains;
    }

    public Object getManualInput() {
        return manualInput;
    }

    public void setManualInput(Object manualInput) {
        this.manualInput = manualInput;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Object getIsPrint() {
        return isPrint;
    }

    public void setIsPrint(Object isPrint) {
        this.isPrint = isPrint;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(Integer ticketCount) {
        this.ticketCount = ticketCount;
    }

    public String getZmPaytoolCode() {
        return zmPaytoolCode;
    }

    public void setZmPaytoolCode(String zmPaytoolCode) {
        this.zmPaytoolCode = zmPaytoolCode;
    }

    public String getZmPaytoolName() {
        return zmPaytoolName;
    }

    public void setZmPaytoolName(String zmPaytoolName) {
        this.zmPaytoolName = zmPaytoolName;
    }

}