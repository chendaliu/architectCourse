package com.ydlclass.proxy.dynamicProxy.aop;

import org.springframework.stereotype.Component;

/**
 * @author
 * @createTime 2023-05-17
 */
@Component
public class DatabaseDataQuery implements DataQuery {
    @Override
    public String query(String queryKey) {
        // 他会使用数据源从数据库查询数据很慢
        System.out.println("正在从数据库查询数据");
        return "result";
    }
}
