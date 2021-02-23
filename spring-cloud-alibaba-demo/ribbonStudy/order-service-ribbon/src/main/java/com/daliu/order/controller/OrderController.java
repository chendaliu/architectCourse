package com.daliu.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getCredit")
    public String getCredit(@RequestParam("userId") Long userId) {
        return this.restTemplate.getForObject("http://credit-service/credit/get/" + userId, String.class);
    }

    @GetMapping(value = "/getStock")
    public String getStock(@RequestParam("stockId") Long stockId) {
        return this.restTemplate.getForObject("http://stock-service/stock/get/" + stockId, String.class);
    }

}
