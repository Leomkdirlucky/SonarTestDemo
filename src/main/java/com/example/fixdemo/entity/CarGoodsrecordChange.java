package com.example.fixdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品变动表(CarGoodsrecordChange)实体类
 *
 * @author makejava
 * @since 2021-05-17 14:55:07
 */
@Mapper
public class CarGoodsrecordChange implements Serializable {
    private static final long serialVersionUID = 545207547040439184L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 油站id
    */
    private Integer stationId;
    /**
    * 记录批次号/记录订单号
    */
    private String mainkey;
    /**
    * 商品编码
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
    * 单位
    */
    private String unit;
    /**
    * 规格
    */
    private String spec;
    /**
    * 商品盘点前库存
    */
    private Integer stockNum;
    /**
     * 商品变动前库存
     */
    private Integer preGoodStock;
    /**
    * 调整库存
    */
    private Integer inventory;
    /**
    * 业务类型:
    0：盘点，1，盘点修正；2：销售，3.积分兑换，
    4.采购、5.调拨、6.其他(等于自定义出/入库)
    */
    private Object recodeType;
    /**
    * 操作员
    */
    private String operator;
    /**
    * 单号
    */
    private String orderCode;
    /**
    * 流水单号
    */
    private String changeCode;
    /**
    * 仓库编号
    */
    private String warehouseCode;
    /**
    * 出入库标识 0 入库 1出库
    */
    private Integer changeType;
    /**
    * 操作时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;


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

    public String getMainkey() {
        return mainkey;
    }

    public void setMainkey(String mainkey) {
        this.mainkey = mainkey;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getPreGoodStock() {
        return preGoodStock;
    }

    public void setPreGoodStock(Integer preGoodStock) {
        this.preGoodStock = preGoodStock;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Object getRecodeType() {
        return recodeType;
    }

    public void setRecodeType(Object recodeType) {
        this.recodeType = recodeType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getChangeCode() {
        return changeCode;
    }

    public void setChangeCode(String changeCode) {
        this.changeCode = changeCode;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Integer getChangeType() {
        return changeType;
    }

    public void setChangeType(Integer changeType) {
        this.changeType = changeType;
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

    @Override
    public String toString() {
        return "CarGoodsrecordChange{" +
                "id=" + id +
                ", stationId=" + stationId +
                ", mainkey='" + mainkey + '\'' +
                ", goodCode='" + goodCode + '\'' +
                ", stripeCode='" + stripeCode + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", unit='" + unit + '\'' +
                ", spec='" + spec + '\'' +
                ", stockNum=" + stockNum +
                ", inventory=" + inventory +
                ", recodeType=" + recodeType +
                ", operator='" + operator + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", changeCode='" + changeCode + '\'' +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", changeType=" + changeType +
                ", addDatetime=" + addDatetime +
                ", updateDatetime=" + updateDatetime +
                '}';
    }
}