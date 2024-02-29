package com.ydlclass.proxy.dynamicProxy.jdk;

/**
 * @author 
 * @createTime 2023-05-17
 */
public interface DataQuery {
    String query(String queryKey);
    String queryAll(String queryKey);
}
