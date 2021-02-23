//package com.daliu.ribbon;
//
//import com.daliu.order.myrule.WeightBalancerRule;
//import com.netflix.loadbalancer.IRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Title:
// * @Description: 搭配com.daliu.order.config.RibbonConfig使用，不适用com.daliu.order.config.RibbonConfig可用注释掉
// * @Author: Daliu
// * @CreateTime: 2021-02-23 01:09
// * @Version:1.0
// **/
//@Configuration
//public class WeightRule {
//    @Bean(name = "weightBalancerRule")
//    public IRule randomRule() {
//        return new WeightBalancerRule();
//    }
//}