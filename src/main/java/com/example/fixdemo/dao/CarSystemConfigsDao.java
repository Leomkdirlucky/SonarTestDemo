package com.example.fixdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fixdemo.entity.CarSystemConfigs;

import java.util.List;

/**
 * @Description TODO
 * @Author laoyj
 * @Date 2022/12/19 14:25
 */
public interface CarSystemConfigsDao extends BaseMapper<CarSystemConfigs> {
    List<String> queryStationIds();
}
