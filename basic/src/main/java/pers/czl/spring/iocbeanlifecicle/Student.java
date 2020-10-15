package pers.czl.spring.iocbeanlifecicle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author: Daliu
 * @CreateTime: 2020-09-25 20:59
 * @Version:1.0
 **/
@Component
public class Student implements BeanPostProcessor {

    private String name;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}