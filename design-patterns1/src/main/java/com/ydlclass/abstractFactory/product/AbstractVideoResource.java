package com.ydlclass.abstractFactory.product;

import java.io.InputStream;

/**
 * @author
 * @createTime 2023-05-11
 */
public abstract class AbstractVideoResource implements Resource {

    // 图片的一些公用的成员变量，方法都可以定义在这个类中
    private String url;


    public AbstractVideoResource() {
    }

    public AbstractVideoResource(String url) {
        this.url = url;
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
