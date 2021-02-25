package com.daliu.order.controller;


import com.daliu.order.api.feign.stock.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
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
        return stockService.getStock(stockId);
    }

    /**
     * 测试token传递
     * @return
     */
    @GetMapping(value = "/testToken")
    public String testToken() {
        return stockService.testToken();
    }

}
