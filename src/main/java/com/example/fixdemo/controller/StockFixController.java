package com.example.fixdemo.controller;

import com.example.fixdemo.service.FixStockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author laoyj
 * @since 2022-10-24 16:43:01
 */
@RestController(value = "stockFixController")
@RequestMapping("stockFix")
public class StockFixController {

    @Resource
    private FixStockService fixStockService;

    @PostMapping("fixBatchStock")
    public boolean fixBatchStock(@RequestParam int stationId, @RequestParam(required = false) String goodCode) {
        return fixStockService.fixBatchStock(stationId, goodCode);
    }

    @PostMapping("clearErrorStock")
    public void clearErrorStock(@RequestParam int stationId, @RequestParam(required = false) String goodCode) {
        fixStockService.clearErrorStock(stationId, goodCode);
    }
}
