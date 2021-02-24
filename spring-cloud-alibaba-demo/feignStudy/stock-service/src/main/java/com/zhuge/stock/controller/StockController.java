package com.zhuge.stock.controller;

import com.zhuge.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private Registration registration;

    @GetMapping("/get/{stockId}")
    public String getStock(@PathVariable("stockId") Long stockId) {
        return "stockId:" + stockId + ">>ip and port:" + getIpAndPort();
    }

    @GetMapping("/getIpAndPort")
    public String getIpAndPort() {
        return registration.getHost() + ":" + registration.getPort();
    }
}
