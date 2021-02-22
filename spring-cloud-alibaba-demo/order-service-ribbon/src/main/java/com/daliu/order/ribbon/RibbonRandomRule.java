package com.daliu.order.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2021-02-22 19:37
 * @Version:1.0
 **/
@Configuration
public class RibbonRandomRule {

    public IRule randomRule() {
        return new RandomRule();
    }
}