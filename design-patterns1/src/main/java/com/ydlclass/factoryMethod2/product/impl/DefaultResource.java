package com.ydlclass.factoryMethod2.product.impl;

import com.ydlclass.factoryMethod2.product.AbstractResource;

import java.io.InputStream;

/**
 * @author
 * @createTime 2023-05-10
 */
public class DefaultResource extends AbstractResource {

    public DefaultResource() {
    }

    public DefaultResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
