package com.ydlclass.proxy.dynamicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author
 * @createTime 2023-05-17
 */
public class Main {
    public static void main(String[] args) {

        // cglib通过Enhancer
        Enhancer enhancer = new Enhancer();
        // 设置他的父类
        enhancer.setSuperclass(DatabaseDataQuery.class);
        // 设置一个方法拦截器，用来拦截方法
        enhancer.setCallback(new CacheMethodInterceptor());
        // 创建代理类
        DatabaseDataQuery databaseDataQuery = (DatabaseDataQuery)enhancer.create();

        databaseDataQuery.query("key1");
        databaseDataQuery.query("key1");
        databaseDataQuery.query("key2");

    }
}
