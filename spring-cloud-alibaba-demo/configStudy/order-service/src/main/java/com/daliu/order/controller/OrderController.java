package com.daliu.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

    @Value("${isNewBusi}")
    private Boolean isNewBusi;

    /**
     * 基于Feign调用服务接口
     * @return
     */
    @GetMapping(value = "/getStock")
    public String getStock(@RequestParam("stockId") Long stockId) {
        if (isNewBusi) {
            return "执行新业务逻辑";
        } else {
            return "执行旧业务逻辑";
        }
    }
}
