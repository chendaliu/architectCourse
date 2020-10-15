package pers.czl.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-07-03 11:53
 * @Version:1.0
 **/
@Service
public class Stuent implements BeanPostProcessor {

    public Stuent() {
        System.out.println();
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}