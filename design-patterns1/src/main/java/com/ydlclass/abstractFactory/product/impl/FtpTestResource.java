package com.ydlclass.abstractFactory.product.impl;

import com.ydlclass.abstractFactory.product.AbstractTextResource;

import java.io.InputStream;

/**
 * @author 
 * @createTime 2023-05-10
 */
public class FtpTestResource extends AbstractTextResource {

    public FtpTestResource() {
    }

    public FtpTestResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
