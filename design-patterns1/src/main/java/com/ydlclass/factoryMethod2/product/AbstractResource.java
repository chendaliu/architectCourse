package com.ydlclass.factoryMethod2.product;

import java.io.InputStream;

/**
 * @author 
 * @createTime 2023-05-10
 */
public abstract class AbstractResource {

    private String url;

    public AbstractResource(){}

    public AbstractResource(String url) {
        this.url = url;
    }

    protected void shared(){
        System.out.println("这是共享方法");
    }

    /**
     * 每个子类需要独自实现的方法
     * @return 字节流
     */
    public abstract InputStream getInputStream();
}
