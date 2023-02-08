package com.example.fixdemo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (CarSystemConfigs)实体类
 *
 * @author makejava
 * @since 2021-09-26 11:48:39
 */
public class CarSystemConfigs implements Serializable {
    private static final long serialVersionUID = 709638915403805167L;
    
    private Integer id;
    /**
    * 配置项目
    */
    private String configKey;
    
    private Object configValue;
    /**
    * 添加时间
    */
    private Date addDatetime;
    /**
    * 更新时间
    */
    private Date updateDatetime;
    /**
    * 备注说明
    */
    private String remark;
    /**
    * 是否有效
    */
    private Object valid;

    /**
     * 油站编号
     */
    private Integer station_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public Object getConfigValue() {
        return configValue;
    }

    public void setConfigValue(Object configValue) {
        this.configValue = configValue;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Object getValid() {
        return valid;
    }

    public void setValid(Object valid) {
        this.valid = valid;
    }

    /**
     * 油站编号
     */
    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }
}