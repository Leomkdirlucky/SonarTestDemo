package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品信息总表(CarGoodsinfo)实体类
 *
 * @author makejava
 * @since 2021-05-12 09:33:02
 */
public class CarGoodsinfo implements Serializable {
    private static final long serialVersionUID = 739828648588963165L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 油站id
     */
    private Integer stationId;
    /**
     * 商品类型层级0
     */
    private String typeCode;
    /**
     * 商品类型层级1
     */
    private String typeCodeLevel1;
    /**
     * 商品类型层级2
     */
    private String typeCodeLevel2;
    /**
     * 编码
     */
    private String goodCode;
    /**
     * 条码
     */
    private String stripeCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 品牌编号
     */
    private String goodsbrandCode;
    /**
     * 商品品牌
     */
    private String goodsbrand;
    /**
     * 箱批
     */
    private Integer boxBatch;
    /**
     * 规格
     */
    private String spec;
    /**
     * 单位
     */
    private String unit;
    /**
     * 商品存量(弃用)
     */
    private Integer stockNum;
    /**
     * 员工价类别（0价格；1折扣）
     */
    private Object staffType;
    /**
     * 员工价（0价格；1折扣）具体值
     */
    private Double staffPrice;
    /**
     * 售价
     */
    private Double sellPrice;
    /**
     * 商品状态 0-停用 1-启用 2-删除
     */
    private Object status;
    /**
     * 操作者
     */
    private String operator;
    /**
     * 备注
     */
    private String remark;
    /**
     * 添加时间
     */
    private Date addDatetime;
    /**
     * 更新时间
     */
    private Date updateDatetime;
    /**
     * 累计值(弃用)
     */
    private Integer addNum;
    /**
     * 线下 是否可兑换（0：否，1：是）
     */
    private Object isExchange;
    /**
     * 线上 是否可兑换（0：否，1：是）
     */
    private Object isExchangeOnline;
    /**
     * 线上兑换的积分值
     */
    private Integer bonusOnline;
    /**
     * 线下兑换的积分值
     */
    private Integer bonus;
    /**
     * 助记码
     */
    private String mnemonicCode;
    /**
     * 最高库存
     */
    private Integer maxStock;
    /**
     * 最低库存
     */
    private Integer minStock;
    /**
     * 参考成本价
     */
    private Integer referBuyPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCodeLevel1() {
        return typeCodeLevel1;
    }

    public void setTypeCodeLevel1(String typeCodeLevel1) {
        this.typeCodeLevel1 = typeCodeLevel1;
    }

    public String getTypeCodeLevel2() {
        return typeCodeLevel2;
    }

    public void setTypeCodeLevel2(String typeCodeLevel2) {
        this.typeCodeLevel2 = typeCodeLevel2;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getStripeCode() {
        return stripeCode;
    }

    public void setStripeCode(String stripeCode) {
        this.stripeCode = stripeCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsbrandCode() {
        return goodsbrandCode;
    }

    public void setGoodsbrandCode(String goodsbrandCode) {
        this.goodsbrandCode = goodsbrandCode;
    }

    public String getGoodsbrand() {
        return goodsbrand;
    }

    public void setGoodsbrand(String goodsbrand) {
        this.goodsbrand = goodsbrand;
    }

    public Integer getBoxBatch() {
        return boxBatch;
    }

    public void setBoxBatch(Integer boxBatch) {
        this.boxBatch = boxBatch;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Object getStaffType() {
        return staffType;
    }

    public void setStaffType(Object staffType) {
        this.staffType = staffType;
    }

    public Double getStaffPrice() {
        return staffPrice;
    }

    public void setStaffPrice(Double staffPrice) {
        this.staffPrice = staffPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Object getStatus() {
        return status;
    }

    public void setStatus(Object status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Integer getAddNum() {
        return addNum;
    }

    public void setAddNum(Integer addNum) {
        this.addNum = addNum;
    }

    public Object getIsExchange() {
        return isExchange;
    }

    public void setIsExchange(Object isExchange) {
        this.isExchange = isExchange;
    }

    public Object getIsExchangeOnline() {
        return isExchangeOnline;
    }

    public void setIsExchangeOnline(Object isExchangeOnline) {
        this.isExchangeOnline = isExchangeOnline;
    }

    public Integer getBonusOnline() {
        return bonusOnline;
    }

    public void setBonusOnline(Integer bonusOnline) {
        this.bonusOnline = bonusOnline;
    }

    public Integer getBonus() {
        return bonus;
    }

    public void setBonus(Integer bonus) {
        this.bonus = bonus;
    }

    public String getMnemonicCode() {
        return mnemonicCode;
    }

    public void setMnemonicCode(String mnemonicCode) {
        this.mnemonicCode = mnemonicCode;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getReferBuyPrice() {
        return referBuyPrice;
    }

    public void setReferBuyPrice(Integer referBuyPrice) {
        this.referBuyPrice = referBuyPrice;
    }

    @Override
    public String toString() {
        return "CarGoodsinfo{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", typeCode='" + typeCode + '\'' +
                ", typeCodeLevel1='" + typeCodeLevel1 + '\'' +
                ", typeCodeLevel2='" + typeCodeLevel2 + '\'' +
                ", goodCode='" + goodCode + '\'' +
                ", stripeCode='" + stripeCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsbrandCode='" + goodsbrandCode + '\'' +
                ", goodsbrand='" + goodsbrand + '\'' +
                ", boxBatch=" + boxBatch +
                ", spec='" + spec + '\'' +
                ", unit='" + unit + '\'' +
                ", stockNum=" + stockNum +
                ", staffType=" + staffType +
                ", staffPrice=" + staffPrice +
                ", sellPrice=" + sellPrice +
                ", status=" + status +
                ", operator='" + operator + '\'' +
                ", remark='" + remark + '\'' +
                ", addDatetime=" + addDatetime +
                ", updateDatetime=" + updateDatetime +
                ", addNum=" + addNum +
                ", isExchange=" + isExchange +
                ", isExchangeOnline=" + isExchangeOnline +
                ", bonusOnline=" + bonusOnline +
                ", bonus=" + bonus +
                ", mnemonicCode='" + mnemonicCode + '\'' +
                ", maxStock=" + maxStock +
                ", minStock=" + minStock +
                ", referBuyPrice=" + referBuyPrice +
                '}';
    }
}