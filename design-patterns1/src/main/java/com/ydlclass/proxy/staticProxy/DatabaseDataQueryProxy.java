package com.ydlclass.proxy.staticProxy;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author
 * @createTime 2023-05-17
 */

public class DatabaseDataQueryProxy implements DataQuery {

    // 我们要实现缓存，需要一个数据结构
    HashMap<String,String> cache = new HashMap<>(256);

    // 你代理谁，应该持有谁
    private DatabaseDataQuery dataQuery;

    public DatabaseDataQueryProxy() {
        // 1、屏蔽被代理对象
        this.dataQuery = new DatabaseDataQuery();
    }

    @Override
    public String query(String queryKey) {
        // 2、对被代理对象的方法做增强

        // 1、查询缓存,命中则返回
        String result = cache.get(queryKey);
        if(result != null){
            System.out.println("命中缓存，走缓存");
            return result;
        }
        // 查询数据库
        result = dataQuery.query(queryKey);
        // 如果有结果，需要将结果返回
        if(result != null){
            cache.put(queryKey,result);
        }
        System.out.println("未命中，走持久层");
        return result;
    }
}
