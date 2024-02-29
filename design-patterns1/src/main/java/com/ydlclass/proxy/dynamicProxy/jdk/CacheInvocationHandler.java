package com.ydlclass.proxy.dynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author 
 * @createTime 2023-05-17
 */
public class CacheInvocationHandler implements InvocationHandler {

    private HashMap<String,String> cache = new LinkedHashMap<>(256);

    private DataQuery databaseDataQuery;

    public CacheInvocationHandler(DatabaseDataQuery databaseDataQuery) {
        this.databaseDataQuery = databaseDataQuery;
    }

    public CacheInvocationHandler() {
        this.databaseDataQuery = new DatabaseDataQuery();
    }

    /**
     *
     * @param proxy the proxy instance that the method was invoked on
     *
     * @param method the {@code Method} instance corresponding to
     * the interface method invoked on the proxy instance.  The declaring
     * class of the {@code Method} object will be the interface that
     * the method was declared in, which may be a superinterface of the
     * proxy interface that the proxy class inherits the method through.
     *
     * @param args an array of objects containing the values of the
     * arguments passed in the method invocation on the proxy instance,
     * or {@code null} if interface method takes no arguments.
     * Arguments of primitive types are wrapped in instances of the
     * appropriate primitive wrapper class, such as
     * {@code java.lang.Integer} or {@code java.lang.Boolean}.
     *
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 1、判断是哪一个方法
        String result = null;
        if("query".equals(method.getName())){
            // 2、查询缓存，命中直接返回
            result = cache.get(args[0].toString());
            if(result != null){
                System.out.println("数据从缓存重获取。");
                return result;
            }

            // 3、未命中，查数据库（需要代理实例）
            result = (String) method.invoke(databaseDataQuery, args);

            // 4、如果查询到了,进行呢缓存
            cache.put(args[0].toString(),result);
            return result;
        }

        // 当其他的方法被调用，不希望被干预，直接调用原生的方法
        return method.invoke(databaseDataQuery,args);
    }
}
