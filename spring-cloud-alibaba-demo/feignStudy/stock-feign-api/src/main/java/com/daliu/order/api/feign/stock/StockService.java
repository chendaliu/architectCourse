package com.daliu.order.api.feign.stock;

import com.daliu.order.api.feign.config.StockFeignConfig;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//configuration 指定这一个FeignClient的配置类
@FeignClient(value = "stock-service", configuration = StockFeignConfig.class)
public interface StockService {

    /**
     * @param stockId
     * @return
     */
//    @GetMapping(value = "/stock/get/{stockId}")
//    String getStock(@PathVariable("stockId") Long stockId);

    /**
     * 修改锲约为Feign的  那么就可以使用默认的注解
     * @param stockId
     * @return
     */
    @RequestLine("GET /stock/get/{stockId}")
    String getStock(@Param("stockId") Long stockId);

}