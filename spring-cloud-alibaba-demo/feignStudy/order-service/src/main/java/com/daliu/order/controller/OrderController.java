package com.daliu.order.controller;

import com.daliu.order.feign.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private StockService stockService;

    /**
     * 基于Feign调用服务接口
     * @return
     */
    @GetMapping(value = "/getStock")
    public String getStock(@RequestParam("stockId") Long stockId) {
        stockService.getStock(stockId);
        return "success";
    }

}
