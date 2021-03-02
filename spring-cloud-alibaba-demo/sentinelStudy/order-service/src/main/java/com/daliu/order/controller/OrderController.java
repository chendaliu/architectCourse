package com.daliu.order.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {


    /**
     * 基于Feign调用服务接口
     * @return
     */
    @GetMapping(value = "/getStock")
    public String getStock(@RequestParam("stockId") Long stockId) {
        return "success";
    }

}
