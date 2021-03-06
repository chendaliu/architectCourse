//package com.daliu.order.feign;
//
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@FeignClient(value = "stock-service")
//public interface StockService {
//
//    /**
//     * @param stockId
//     * @return
//     */
//    @GetMapping(value = "/stock/get/{stockId}")
//    String getStock(@PathVariable("stockId") Long stockId);
//
//}