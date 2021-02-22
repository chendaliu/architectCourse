package com.daliu.order.ribbon;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: 负载均衡配置，不同的服务使用不同的负载均衡算法
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2021-02-22 18:59
 * @Version:1.0
 **/
@Configuration
@RibbonClients(value = {
        //轮询
        @RibbonClient(name="credit-service", configuration = RibbonRoundRobinRule.class),
        //随机
        @RibbonClient(name="stock-service", configuration = RibbonRandomRule.class)
})
public class RibbonConfig {

}