package com.ydlclass.proxy.dynamicProxy.aop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 
 * @createTime 2023-05-17
 */
public class Cache {
    private static Map<String,String> map = new ConcurrentHashMap<>(256);

    public static String get(String key){
        return map.get(key);
    }

    public static void put(String key,String value){
        map.put(key, value);
    }
}
