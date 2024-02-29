package com.ydlclass.factoryMethod2.product.impl;

import com.ydlclass.factoryMethod2.product.AbstractResource;

import java.io.InputStream;

/**
 * @author
 * @createTime 2023-05-10
 */
public class FtpResource extends AbstractResource {

    public FtpResource() {
    }

    public FtpResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
