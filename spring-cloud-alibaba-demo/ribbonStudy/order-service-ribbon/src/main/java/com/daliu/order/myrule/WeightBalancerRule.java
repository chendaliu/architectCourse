//package com.daliu.order.myrule;
//
//import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
//import com.alibaba.cloud.nacos.ribbon.NacosServer;
//import com.alibaba.nacos.api.exception.NacosException;
//import com.alibaba.nacos.api.naming.NamingService;
//import com.alibaba.nacos.api.naming.pojo.Instance;
//import com.netflix.client.config.IClientConfig;
//import com.netflix.loadbalancer.AbstractLoadBalancerRule;
//import com.netflix.loadbalancer.BaseLoadBalancer;
//import com.netflix.loadbalancer.Server;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @Title: 权重
// * @Description:
// * @Author: Daliu
// * @CreateTime: 2021-02-23 00:05
// * @Version:1.0
// **/
//@Configuration
//public class WeightBalancerRule extends AbstractLoadBalancerRule {
//    private static final Logger log = LoggerFactory.getLogger(WeightBalancerRule.class);
//
//    @Autowired
//    private NacosDiscoveryProperties discoveryProperties;
//
//    @Override
//    public void initWithNiwsConfig(IClientConfig clientConfig) {
//        //读取配置文件并且初始化,ribbon内部的 几乎用不上
//    }
//
//    @Override
//    public Server choose(Object key) {
//        try {
//            log.info("key:{}",key);
//            //获取负载均衡器
//            BaseLoadBalancer baseLoadBalancer = (BaseLoadBalancer) this.getLoadBalancer();
//            log.info("baseLoadBalancer--->:{}",baseLoadBalancer);
//
//            //获取微服务的名称
//            String serviceName = baseLoadBalancer.getName();
//
//            //获取Nocas服务发现的相关组件API
//            NamingService namingService = discoveryProperties.namingServiceInstance();
//
//            //获取 一个基于nacos client 实现权重的负载均衡算法
//            Instance instance = namingService.selectOneHealthyInstance(serviceName);
//
//            //返回一个server
//            return new NacosServer(instance);
//        } catch (NacosException e) {
//            log.error("自定义负载均衡算法错误");
//        }
//        return null;
//    }
//}