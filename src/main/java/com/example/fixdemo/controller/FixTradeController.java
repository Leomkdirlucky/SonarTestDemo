package com.example.fixdemo.controller;

import cn.hutool.json.JSONObject;
import com.example.fixdemo.service.FixShopOrderService;
import com.example.fixdemo.service.FixTradeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * @author laoyj
 * @since 2022-11-09 15:08:49
 */
@RestController(value = "fixTradeController")
@RequestMapping("tradeFix")
public class FixTradeController {
    @Resource
    private FixTradeService fixTradeService;

    @Resource
    private FixShopOrderService fixShopOrderService;

    @PostMapping("fixGroupGoodsOrder")
    public boolean fixBatchStock(@RequestBody List<String> tradeNoList) {
        return fixTradeService.fixWrongTrade(tradeNoList);
    }

    @PostMapping("fixShopOrder")
    public boolean fixShopOrder() throws ParseException {
        fixShopOrderService.fixShopOrder();
        return true;
    }

    @PostMapping("fixShift")
    public boolean fixShift() throws ParseException {
        fixShopOrderService.fixShift();
        return true;
    }

    @PostMapping("fixShopOrderHandler")
    public boolean fixShopOrderHandler(@RequestParam String stationId, @RequestParam String beginTime
            , @RequestParam String endTime, @RequestParam List<String> tradeList) {
        fixShopOrderService.fixShopOrderHandler(stationId, beginTime, endTime, tradeList);
        return true;
    }

    @PostMapping("getShopSEDate")
    public boolean getShopSEDate(){
        fixShopOrderService.getShopSEDate();
        return true;
    }

    @PostMapping("fixBuyPrice")
    public boolean fixBuyPrice() throws Exception {
        fixShopOrderService.fixOrderGoodPrice();
        return true;
    }
}
