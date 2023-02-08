package com.example.fixdemo.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.example.fixdemo.dao.CarGoodsinfoDao;
import com.example.fixdemo.dao.CarGoodsrecordChangeDao;
import com.example.fixdemo.dao.CarGoodstockBatchDao;
import com.example.fixdemo.entity.CarGoodsrecordChange;
import com.example.fixdemo.entity.CarGoodstockBatch;
import com.example.fixdemo.service.FixStockService;
import com.example.fixdemo.vo.GoodsStockVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author laoyj
 * @since 2022-10-24 17:07:48
 */
@Service
public class FixStockServiceImpl implements FixStockService {
    @Resource
    private CarGoodstockBatchDao stockBatchDao;

    @Resource
    private CarGoodsrecordChangeDao changeDao;

    @Resource
    private CarGoodsinfoDao infoDao;

    private List<String> goodCodeList = new ArrayList<>();

    /**
     * 修复批次库存小于仓库库存的问题
     *
     * @param stationId 油站id
     * @param goodCode  商品编码
     * @return 修复结果
     **/
    @Override
    @Transactional
    public boolean fixBatchStock(int stationId, String goodCode) {
        //clearErrorStock(stationId, goodCode);
        List<GoodsStockVo> goodsStockVos = stockBatchDao.queryGoodsStockDiffer(stationId, goodCode);
        goodsStockVos.removeIf(s -> s.getDifferNum() == 0);
        String prefix = "PC" + DateUtil.format(new Date(), "yyyyMMdd");
        CarGoodstockBatch batch;
        DateTime date = DateUtil.date();
        DecimalFormat decimalFormat = new DecimalFormat("0000");
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = dateFormat.format(new Date());
        String changePrefix = decimalFormat.format(stationId) + format;
        String updateSql = "UPDATE car_goodstock_batch SET stock_num = stock_num - {}, update_datetime = NOW() WHERE id = {} AND warehouse_code = '{}' AND stock_mainkey = '{}' AND good_code = '{}';";
        String insertSql = "INSERT INTO car_goodstock_batch(id, station_id, warehouse_code, stock_mainkey, good_code, stripe_code, buy_price, stock_num, add_datetime, update_datetime, good_id, remark) VALUES (null, 560, '{}', '{}', '{}', '{}', 1, {}, NOW(), NOW(), 0, '修正库存数据');";
        System.out.println("仓库库存大于批次库存，批次库存增加库存");
        for (GoodsStockVo goodsStockVo : goodsStockVos) {
            if (goodsStockVo.getDifferNum() < 0) {
                // 仓库库存大于批次库存，批次库存增加库存
                batch = getAddStockBatch(stationId, goodsStockVo.getGoodCode(), goodsStockVo.getWhCode(), null, null);
                if (batch == null) {
                    System.out.println(StrUtil.format("没有获取到批次库存记录：变更库存值{}，商品编码{}，仓库编码{}", -goodsStockVo.getDifferNum(), goodsStockVo.getGoodCode(), goodsStockVo.getWhCode()));
                    System.out.println(StrUtil.format(insertSql, goodsStockVo.getWhCode(), generateMainKey("PC" + DateUtil.format(new Date(), "yyyyMMdd")), goodsStockVo.getGoodCode(), goodsStockVo.getStripeCode(), -goodsStockVo.getDifferNum()));
                } else {
                    goodCodeList.add(goodsStockVo.getGoodCode());
                    System.out.println(StrUtil.format(updateSql, goodsStockVo.getDifferNum(), batch.getId(), goodsStockVo.getWhCode(), batch.getStockMainkey(), goodsStockVo.getGoodCode()));
                }
            }
        }
        System.out.println("批次库存大于仓库库存，批次库存减少库存");
        for (GoodsStockVo goodsStockVo : goodsStockVos) {
            int tempStock = goodsStockVo.getDifferNum();
            // 批次库存大于仓库库存，批次库存减少库存
            if (goodsStockVo.getDifferNum() > 0) {
                batch = getReduceStockBatch(stationId, goodsStockVo.getGoodCode(), goodsStockVo.getWhCode(), null, null);
                if (batch == null) {
                    System.out.println(StrUtil.format("没有获取到批次库存记录：变更库存值{}，商品编码{}，仓库编码{}", -goodsStockVo.getDifferNum(), goodsStockVo.getGoodCode(), goodsStockVo.getWhCode()));
                } else {
                    while (tempStock > 0) {
                        if (batch == null) {
                            System.out.println(StrUtil.format("没有批次能减了：{}", goodsStockVo.getGoodCode()));
                            break;
                        }
                        if (tempStock >= batch.getStockNum()) {
                            System.out.println(StrUtil.format(updateSql, batch.getStockNum(), batch.getId(), goodsStockVo.getWhCode(), batch.getStockMainkey(), goodsStockVo.getGoodCode()));
                            tempStock -= batch.getStockNum();
                            batch = getReduceStockBatch(stationId, goodsStockVo.getGoodCode(), goodsStockVo.getWhCode(), batch.getId().toString(), batch.getAddDatetime());
                        } else {
                            System.out.println(StrUtil.format(updateSql, tempStock, batch.getId(), goodsStockVo.getWhCode(), batch.getStockMainkey(), goodsStockVo.getGoodCode()));
                            tempStock -= batch.getStockNum();
                        }
                    }
                    goodCodeList.add(goodsStockVo.getGoodCode());
                    //System.out.println(StrUtil.format(updateSql, goodsStockVo.getDifferNum(), batch.getId(), goodsStockVo.getWhCode(), batch.getStockMainkey(), goodsStockVo.getGoodCode()));
                }
            }
        }
        //List<CarGoodsinfo> goodsinfoList = new LambdaQueryChainWrapper<>(infoDao)
        //        .in(CarGoodsinfo::getGoodCode, goodCodeList).eq(CarGoodsinfo::getStationId, stationId)
        //        .groupBy(CarGoodsinfo::getGoodCode).orderByAsc(CarGoodsinfo::getId).list();
        //System.out.println(StrUtil.format("{}  {}  {}", "商品名称", "商品编码", "条码"));
        //for (CarGoodsinfo carGoodsinfo : goodsinfoList) {
        //    System.out.println(StrUtil.format("{}", carGoodsinfo.getGoodCode()));
        //}
        return true;
    }

    private CarGoodstockBatch getAddStockBatch(int stationId, String goodCode, String whCode, String id, Date addDateTime) {
        CarGoodstockBatch batch;
        if (id == null) {
            batch = new LambdaQueryChainWrapper<>(stockBatchDao)
                    .eq(CarGoodstockBatch::getStationId, stationId)
                    .eq(CarGoodstockBatch::getGoodCode, goodCode)
                    .eq(CarGoodstockBatch::getWarehouseCode, whCode)
                    .orderByDesc(CarGoodstockBatch::getAddDatetime).last("limit 1").one();

        } else {
            batch = new LambdaQueryChainWrapper<>(stockBatchDao)
                    .eq(CarGoodstockBatch::getGoodCode, goodCode)
                    .eq(CarGoodstockBatch::getWarehouseCode, whCode)
                    .lt(CarGoodstockBatch::getAddDatetime, addDateTime)
                    .orderByDesc(CarGoodstockBatch::getAddDatetime).last("limit 1").one();
        }
        if (batch == null) {
            return null;
        }
        Integer count = new LambdaQueryChainWrapper<>(stockBatchDao)
                .eq(CarGoodstockBatch::getStationId, stationId)
                .eq(CarGoodstockBatch::getGoodCode, goodCode)
                .eq(CarGoodstockBatch::getWarehouseCode, whCode)
                .eq(CarGoodstockBatch::getStockMainkey, batch.getStockMainkey()).count();
        if (count > 1) {
            batch = getAddStockBatch(stationId, goodCode, whCode, batch.getId().toString(), batch.getAddDatetime());
        }
        return batch;
    }

    private CarGoodstockBatch getReduceStockBatch(int stationId, String goodCode, String whCode, String id, Date addDateTime) {
        CarGoodstockBatch batch;
        if (id == null) {
            batch = new LambdaQueryChainWrapper<>(stockBatchDao)
                    .eq(CarGoodstockBatch::getStationId, stationId)
                    .eq(CarGoodstockBatch::getGoodCode, goodCode)
                    .eq(CarGoodstockBatch::getWarehouseCode, whCode)
                    .ne(CarGoodstockBatch::getStockNum, 0)
                    .orderByDesc(CarGoodstockBatch::getAddDatetime).last("limit 1").one();

        } else {
            batch = new LambdaQueryChainWrapper<>(stockBatchDao)
                    .eq(CarGoodstockBatch::getGoodCode, goodCode)
                    .eq(CarGoodstockBatch::getWarehouseCode, whCode)
                    //.le(CarGoodstockBatch::getAddDatetime, addDateTime)
                    .lt(CarGoodstockBatch::getId, id)
                    .ne(CarGoodstockBatch::getStockNum, 0)
                    .orderByDesc(CarGoodstockBatch::getAddDatetime).last("limit 1").one();
        }
        if (batch == null) {
            return null;
        }
        Integer count = new LambdaQueryChainWrapper<>(stockBatchDao)
                .eq(CarGoodstockBatch::getStationId, stationId)
                .eq(CarGoodstockBatch::getGoodCode, goodCode)
                .eq(CarGoodstockBatch::getWarehouseCode, whCode)
                .eq(CarGoodstockBatch::getStockMainkey, batch.getStockMainkey()).count();
        if (count > 1) {
            batch = getReduceStockBatch(stationId, goodCode, whCode, batch.getId().toString(), batch.getAddDatetime());
        }
        return batch;
    }

    private String generateMainKey(String prefix) {
        String mainkey = prefix + RandomUtil.randomNumbers(3);
        CarGoodstockBatch batch = new LambdaQueryChainWrapper<>(stockBatchDao)
                .eq(CarGoodstockBatch::getStockMainkey, mainkey).last("limit 1").one();
        if (batch != null) {
            mainkey = generateMainKey(prefix);
        }
        return mainkey;
    }

    private String generateChangeCode(String prefix) {
        String changeCode = prefix + RandomUtil.randomNumbers(4);
        CarGoodsrecordChange change = new LambdaQueryChainWrapper<>(changeDao)
                .eq(CarGoodsrecordChange::getChangeCode, changeCode).last("limit 1").one();
        if (change != null) {
            changeCode = generateChangeCode(prefix);
        }
        return changeCode;
    }

    /**
     * 重复和负数的库存都置为0
     *
     * @param stationId 油站id
     **/
    @Override
    public void clearErrorStock(int stationId, String goodCode) {
        // 重复和负数的库存都置为0
        List<Integer> hasClearId = new ArrayList<>();
        List<CarGoodstockBatch> repeatBatchList = stockBatchDao.queryRepeatBatch();
        List<CarGoodstockBatch> minusBatchList = new LambdaQueryChainWrapper<>(stockBatchDao)
                .lt(CarGoodstockBatch::getStockNum, 0).list();
        String updateSql = "UPDATE car_goodstock_batch SET stock_num = stock_num - {}, update_datetime = NOW() WHERE id = {} AND station_id = {} AND warehouse_code = '{}' AND stock_mainkey = '{}' AND good_code = '{}';";
        System.out.println("重复库存处理");
        for (CarGoodstockBatch batch : repeatBatchList) {
            if (StrUtil.isNotBlank(goodCode) && !goodCode.equals(batch.getGoodCode())) {
                continue;
            }
            goodCodeList.add(batch.getGoodCode());
            List<CarGoodstockBatch> batchList = new LambdaQueryChainWrapper<>(stockBatchDao)
                    .eq(CarGoodstockBatch::getGoodCode, batch.getGoodCode())
                    .eq(CarGoodstockBatch::getWarehouseCode, batch.getWarehouseCode())
                    .eq(CarGoodstockBatch::getStockMainkey, batch.getStockMainkey()).list();
            for (CarGoodstockBatch carGoodstockBatch : batchList) {
                if (carGoodstockBatch.getStockNum() == 0) {
                    continue;
                }
                hasClearId.add(carGoodstockBatch.getId());
                System.out.println(StrUtil.format(updateSql, carGoodstockBatch.getStockNum(), carGoodstockBatch.getId(), stationId, carGoodstockBatch.getWarehouseCode(), carGoodstockBatch.getStockMainkey(), carGoodstockBatch.getGoodCode()));
            }
        }
        System.out.println("负数库存处理");
        for (CarGoodstockBatch batch : minusBatchList) {
            if (StrUtil.isNotBlank(goodCode) && !goodCode.equals(batch.getGoodCode())) {
                continue;
            }
            if (batch.getStockNum() == 0) {
                continue;
            }
            if (hasClearId.contains(batch.getId())) {
                continue;
            }
            goodCodeList.add(batch.getGoodCode());
            System.out.println(StrUtil.format(updateSql, batch.getStockNum(), batch.getId(), stationId, batch.getWarehouseCode(), batch.getStockMainkey(), batch.getGoodCode()));
        }
    }
}
