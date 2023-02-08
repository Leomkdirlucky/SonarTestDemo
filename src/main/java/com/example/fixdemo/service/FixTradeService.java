package com.example.fixdemo.service;

import java.util.List;

/**
 * 加德士组合商品同步重复，导致商品金额和优惠极大
 * @Description TODO
 * @Author laoyj
 * @Date 2022/11/9 9:44
 */
public interface FixTradeService {
    boolean fixWrongTrade(List<String> tradeNoList);
}
