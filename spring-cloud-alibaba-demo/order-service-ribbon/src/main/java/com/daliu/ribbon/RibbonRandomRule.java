package com.daliu.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Title: 随机
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2021-02-22 19:37
 * @Version:1.0
 **/
@Configuration
public class RibbonRandomRule {

    @Bean(name = "randomRule")
    public IRule randomRule() {
        return new RandomRule();
    }
}