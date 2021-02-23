//package com.daliu.order.config;
//
//import org.springframework.cloud.netflix.ribbon.RibbonClients;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Title: 负载均衡配置，不同的服务使用不同的负载均衡算法
// * @Description:
// * @Author: wb-ccl670938
// * @CreateTime: 2021-02-22 18:59
// * @Version:1.0
// **/
//@Configuration
//@RibbonClients(value = {
//        //轮询
//        //@RibbonClient(name="credit-service", configuration = com.daliu.ribbon.RibbonRoundRobinRule.class),
//        //随机
//        //@RibbonClient(name="stock-service", configuration = com.daliu.ribbon.RibbonRandomRule.class)
//        //权重
//        //@RibbonClient(name="credit-service", configuration = WeightRule.class)
//})
//public class RibbonConfig {
//
//}