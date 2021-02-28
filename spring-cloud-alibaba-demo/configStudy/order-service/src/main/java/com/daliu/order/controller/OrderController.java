package com.daliu.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Value("${isNewBusi}")
    private String isNewBusi;

    /**
     * 基于Feign调用服务接口
     * @return
     */
    @GetMapping(value = "/getStock")
    public String getStock(@RequestParam("stockId") Long stockId) {
        if ("1".equals(this.isNewBusi)) {
            return "执行新业务逻辑";
        } else {
            return "执行旧业务逻辑";
        }
    }
}
