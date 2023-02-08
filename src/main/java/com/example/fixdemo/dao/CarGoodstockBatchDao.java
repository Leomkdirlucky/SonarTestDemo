package com.example.fixdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.fixdemo.entity.CarGoodstockBatch;
import com.example.fixdemo.vo.GoodsStockVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description TODO
 * @Author laoyj
 * @Date 2022/10/24 17:08
 */
@Mapper
public interface CarGoodstockBatchDao extends BaseMapper<CarGoodstockBatch> {
    /**
     * 查找商品批次库存和仓库库存
     * <p>批次库存不为0</p>
     * <p>以商品编码和仓库编码分组</p>
     *
     * @param goodCode
     * @return 商品批次库存和仓库库存
     */
    List<GoodsStockVo> queryGoodsStockDiffer(int stationId, String goodCode);

    /**
     * 查询重复批次记录
     **/
    List<CarGoodstockBatch> queryRepeatBatch();
}
