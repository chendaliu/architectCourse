package com.daliu.order.api.feign.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Title:
 * @Description: 这个类上千万不要添加@Configuration,不然会被作为全局配置文件共享
 * @Author: Daliu
 **/
public class StockFeignConfig {
    @Bean
    public Logger.Level level() {
        return Logger.Level.FULL;
    }

    /**
     * 这里配置契约（控制使用哪一套注解）
     * 根据SpringBoot自动装配FeignClientsConfiguration 的FeignClient的契约是SpringMvc
     *
     * 通过修改契约为默认的Feign的锲约，那么就可以使用Feign默认的注解
     * @return
     */
    @Bean
    public Contract feiContract() {
        return new Contract.Default();
    }
}