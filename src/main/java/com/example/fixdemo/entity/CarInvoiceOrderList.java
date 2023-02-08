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
 * 开票订单表
 * </p>
 *
 * @author hongyuan
 * @since 2022-03-08
 */
@TableName("car_invoice_order_list")
@ApiModel(value = "CarInvoiceOrderList对象", description = "开票订单表")
public class CarInvoiceOrderList implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分布式ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty("油站序号")
    private Integer stationId;

    @ApiModelProperty("交易号")
    private String tradeNo;

    @ApiModelProperty("订单号（油品、便利店）")
    private String orderNo;

    @ApiModelProperty("添加类型（0：油品；1.普通商品；2.机油类商品；3.自定义）")
    private Integer addType;

    @ApiModelProperty("用户标识")
    private String zhimaid;

    @ApiModelProperty("发票类型 0.纸质 1.电子")
    private Integer invoiceType;

    @ApiModelProperty("发票单号")
    private String invoiceNo;

    @ApiModelProperty("发票抬头")
    private String invoiceTitle;

    @ApiModelProperty("发票税号")
    private String invoiceTaxno;

    @ApiModelProperty("公司地址")
    private String invoiceAddr;

    @ApiModelProperty("联系电话")
    private String invoiceTel;

    @ApiModelProperty("发票电子邮箱")
    private String invoiceEmail;

    @ApiModelProperty("开户银行")
    private String invoiceBankname;

    @ApiModelProperty("银行账号")
    private String invoiceBankaccount;

    @ApiModelProperty("发票金额")
    private Integer invoiceTotal;

    @ApiModelProperty("发票商品数量")
    private Integer invoiceNumber;

    @ApiModelProperty("发票项单位")
    private String invoiceUom;

    @ApiModelProperty("商品名称")
    private String invoiceGoodsname;

    @ApiModelProperty("商品分类编码")
    private String invoiceGoodsCatalogCode;

    @ApiModelProperty("发票规格型号")
    private String invoiceSpec;

    @ApiModelProperty("发票商品单价")
    private Integer invoicePrice;

    @ApiModelProperty("发票状态 0.未开票 1.已提交开票 2.已完成开票 3.已取消开票 4.开票失败 5.待处理(航信)")
    private Integer invoiceStatus;

    @ApiModelProperty("发票审核状态 0.未审核 1.已审核 2.已驳回")
    private Integer invoiceReview;

    @ApiModelProperty("用户授权状态 0.未授权 1.已授权 2.授权中")
    private Integer userAuthStatus;

    @ApiModelProperty("插入卡包状态：0.未插入；1.已插入 2.插入失败")
    private Integer insCardStatus;

    @ApiModelProperty("首次交付。0.未交付；1.微信卡包；2.打印；3.邮箱；")
    private Integer firstDelivery;

    @ApiModelProperty("打印设备")
    private String printdevice;

    @ApiModelProperty("错误信息")
    private String errorMsg;

    @ApiModelProperty("添加时间")
    private LocalDateTime addDatetime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateDatetime;

    @ApiModelProperty("处理时间")
    private LocalDateTime procDatetime;

    @ApiModelProperty("用户授权时间")
    private LocalDateTime userauthDatetime;

    @ApiModelProperty("插卡时间")
    private LocalDateTime addcardDatetime;

    @ApiModelProperty("首次通知时间")
    private LocalDateTime notifyDatetime;

    @ApiModelProperty("审核时间")
    private LocalDateTime reviewDatetime;

    @ApiModelProperty("其他纳税项备注")
    private String invoiceRemarks;

    @ApiModelProperty("邮件推送状态（0：未推送，默认值 1：需推送 2：已推送）")
    private Integer pushEmailStatus;

    @ApiModelProperty("发票折扣总额")
    private Integer invoiceDiscountTotal;

    @ApiModelProperty("油站挂牌价")
    private Integer stationPrice;

    @ApiModelProperty("处理状态（0：待处理，默认值 1：已处理）")
    private Integer dealStatus;

    @ApiModelProperty("用户自定义是否打印（0：不打印 1：打印，默认值）")
    private Integer whetherPrint;

    @ApiModelProperty("用户自定义发票打印优惠类型（-1：未启用，默认值 0：简化格式即不打印优惠 1：规范格式即打印优惠）")
    private Integer printDiscountType;

    @ApiModelProperty("用户自定义打印次数，即每次自主打印一次+1")
    private Integer printNum;

    @ApiModelProperty("场景值 0-未知")
    private Integer sceneId;

    @ApiModelProperty("开票类型。p:电子增值税普通发票（默认） ps:电子收购发票 c:纸质普通发票 cs:纸质收购票 s:增值税专用发票 py:成品油发票")
    private String fpType;

    @ApiModelProperty("是否有效")
    private Integer valid;

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
    public Integer getAddType() {
        return addType;
    }

    public void setAddType(Integer addType) {
        this.addType = addType;
    }
    public String getZhimaid() {
        return zhimaid;
    }

    public void setZhimaid(String zhimaid) {
        this.zhimaid = zhimaid;
    }
    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }
    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }
    public String getInvoiceTaxno() {
        return invoiceTaxno;
    }

    public void setInvoiceTaxno(String invoiceTaxno) {
        this.invoiceTaxno = invoiceTaxno;
    }
    public String getInvoiceAddr() {
        return invoiceAddr;
    }

    public void setInvoiceAddr(String invoiceAddr) {
        this.invoiceAddr = invoiceAddr;
    }
    public String getInvoiceTel() {
        return invoiceTel;
    }

    public void setInvoiceTel(String invoiceTel) {
        this.invoiceTel = invoiceTel;
    }
    public String getInvoiceEmail() {
        return invoiceEmail;
    }

    public void setInvoiceEmail(String invoiceEmail) {
        this.invoiceEmail = invoiceEmail;
    }
    public String getInvoiceBankname() {
        return invoiceBankname;
    }

    public void setInvoiceBankname(String invoiceBankname) {
        this.invoiceBankname = invoiceBankname;
    }
    public String getInvoiceBankaccount() {
        return invoiceBankaccount;
    }

    public void setInvoiceBankaccount(String invoiceBankaccount) {
        this.invoiceBankaccount = invoiceBankaccount;
    }
    public Integer getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceTotal(Integer invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    public String getInvoiceUom() {
        return invoiceUom;
    }

    public void setInvoiceUom(String invoiceUom) {
        this.invoiceUom = invoiceUom;
    }
    public String getInvoiceGoodsname() {
        return invoiceGoodsname;
    }

    public void setInvoiceGoodsname(String invoiceGoodsname) {
        this.invoiceGoodsname = invoiceGoodsname;
    }
    public String getInvoiceGoodsCatalogCode() {
        return invoiceGoodsCatalogCode;
    }

    public void setInvoiceGoodsCatalogCode(String invoiceGoodsCatalogCode) {
        this.invoiceGoodsCatalogCode = invoiceGoodsCatalogCode;
    }
    public String getInvoiceSpec() {
        return invoiceSpec;
    }

    public void setInvoiceSpec(String invoiceSpec) {
        this.invoiceSpec = invoiceSpec;
    }
    public Integer getInvoicePrice() {
        return invoicePrice;
    }

    public void setInvoicePrice(Integer invoicePrice) {
        this.invoicePrice = invoicePrice;
    }
    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
    public Integer getInvoiceReview() {
        return invoiceReview;
    }

    public void setInvoiceReview(Integer invoiceReview) {
        this.invoiceReview = invoiceReview;
    }
    public Integer getUserAuthStatus() {
        return userAuthStatus;
    }

    public void setUserAuthStatus(Integer userAuthStatus) {
        this.userAuthStatus = userAuthStatus;
    }
    public Integer getInsCardStatus() {
        return insCardStatus;
    }

    public void setInsCardStatus(Integer insCardStatus) {
        this.insCardStatus = insCardStatus;
    }
    public Integer getFirstDelivery() {
        return firstDelivery;
    }

    public void setFirstDelivery(Integer firstDelivery) {
        this.firstDelivery = firstDelivery;
    }
    public String getPrintdevice() {
        return printdevice;
    }

    public void setPrintdevice(String printdevice) {
        this.printdevice = printdevice;
    }
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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
    public LocalDateTime getProcDatetime() {
        return procDatetime;
    }

    public void setProcDatetime(LocalDateTime procDatetime) {
        this.procDatetime = procDatetime;
    }
    public LocalDateTime getUserauthDatetime() {
        return userauthDatetime;
    }

    public void setUserauthDatetime(LocalDateTime userauthDatetime) {
        this.userauthDatetime = userauthDatetime;
    }
    public LocalDateTime getAddcardDatetime() {
        return addcardDatetime;
    }

    public void setAddcardDatetime(LocalDateTime addcardDatetime) {
        this.addcardDatetime = addcardDatetime;
    }
    public LocalDateTime getNotifyDatetime() {
        return notifyDatetime;
    }

    public void setNotifyDatetime(LocalDateTime notifyDatetime) {
        this.notifyDatetime = notifyDatetime;
    }
    public LocalDateTime getReviewDatetime() {
        return reviewDatetime;
    }

    public void setReviewDatetime(LocalDateTime reviewDatetime) {
        this.reviewDatetime = reviewDatetime;
    }
    public String getInvoiceRemarks() {
        return invoiceRemarks;
    }

    public void setInvoiceRemarks(String invoiceRemarks) {
        this.invoiceRemarks = invoiceRemarks;
    }
    public Integer getPushEmailStatus() {
        return pushEmailStatus;
    }

    public void setPushEmailStatus(Integer pushEmailStatus) {
        this.pushEmailStatus = pushEmailStatus;
    }
    public Integer getInvoiceDiscountTotal() {
        return invoiceDiscountTotal;
    }

    public void setInvoiceDiscountTotal(Integer invoiceDiscountTotal) {
        this.invoiceDiscountTotal = invoiceDiscountTotal;
    }
    public Integer getStationPrice() {
        return stationPrice;
    }

    public void setStationPrice(Integer stationPrice) {
        this.stationPrice = stationPrice;
    }
    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }
    public Integer getWhetherPrint() {
        return whetherPrint;
    }

    public void setWhetherPrint(Integer whetherPrint) {
        this.whetherPrint = whetherPrint;
    }
    public Integer getPrintDiscountType() {
        return printDiscountType;
    }

    public void setPrintDiscountType(Integer printDiscountType) {
        this.printDiscountType = printDiscountType;
    }
    public Integer getPrintNum() {
        return printNum;
    }

    public void setPrintNum(Integer printNum) {
        this.printNum = printNum;
    }
    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }
    public String getFpType() {
        return fpType;
    }

    public void setFpType(String fpType) {
        this.fpType = fpType;
    }
    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return "CarInvoiceOrderList{" +
            "id=" + id +
            ", stationId=" + stationId +
            ", tradeNo=" + tradeNo +
            ", orderNo=" + orderNo +
            ", addType=" + addType +
            ", zhimaid=" + zhimaid +
            ", invoiceType=" + invoiceType +
            ", invoiceNo=" + invoiceNo +
            ", invoiceTitle=" + invoiceTitle +
            ", invoiceTaxno=" + invoiceTaxno +
            ", invoiceAddr=" + invoiceAddr +
            ", invoiceTel=" + invoiceTel +
            ", invoiceEmail=" + invoiceEmail +
            ", invoiceBankname=" + invoiceBankname +
            ", invoiceBankaccount=" + invoiceBankaccount +
            ", invoiceTotal=" + invoiceTotal +
            ", invoiceNumber=" + invoiceNumber +
            ", invoiceUom=" + invoiceUom +
            ", invoiceGoodsname=" + invoiceGoodsname +
            ", invoiceGoodsCatalogCode=" + invoiceGoodsCatalogCode +
            ", invoiceSpec=" + invoiceSpec +
            ", invoicePrice=" + invoicePrice +
            ", invoiceStatus=" + invoiceStatus +
            ", invoiceReview=" + invoiceReview +
            ", userAuthStatus=" + userAuthStatus +
            ", insCardStatus=" + insCardStatus +
            ", firstDelivery=" + firstDelivery +
            ", printdevice=" + printdevice +
            ", errorMsg=" + errorMsg +
            ", addDatetime=" + addDatetime +
            ", updateDatetime=" + updateDatetime +
            ", procDatetime=" + procDatetime +
            ", userauthDatetime=" + userauthDatetime +
            ", addcardDatetime=" + addcardDatetime +
            ", notifyDatetime=" + notifyDatetime +
            ", reviewDatetime=" + reviewDatetime +
            ", invoiceRemarks=" + invoiceRemarks +
            ", pushEmailStatus=" + pushEmailStatus +
            ", invoiceDiscountTotal=" + invoiceDiscountTotal +
            ", stationPrice=" + stationPrice +
            ", dealStatus=" + dealStatus +
            ", whetherPrint=" + whetherPrint +
            ", printDiscountType=" + printDiscountType +
            ", printNum=" + printNum +
            ", sceneId=" + sceneId +
            ", fpType=" + fpType +
            ", valid=" + valid +
        "}";
    }
}
