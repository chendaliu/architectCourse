//package com.daliu.ribbon;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RoundRobinRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Title: 轮询
// * @Description:搭配com.daliu.order.config.RibbonConfig使用，不适用com.daliu.order.config.RibbonConfig可用注释掉
// * @Author: wb-ccl670938
// * @CreateTime: 2021-02-22 19:36
// * @Version:1.0
// **/
//@Configuration
//public class RibbonRoundRobinRule {
//
//    @Bean(name = "roundRobinRule")
//    public IRule roundRobinRule() {
//        return new RoundRobinRule();
//    }
//}