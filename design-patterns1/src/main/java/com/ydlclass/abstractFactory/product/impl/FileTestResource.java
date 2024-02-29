package com.ydlclass.abstractFactory.product.impl;

import com.ydlclass.abstractFactory.product.AbstractTextResource;

import java.io.InputStream;

/**
 * @author
 * @createTime 2023-05-10
 */
public class FileTestResource extends AbstractTextResource {

    public FileTestResource() {
    }

    public FileTestResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
