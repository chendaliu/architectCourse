package com.ydlclass.abstractFactory.product.impl;

import com.ydlclass.abstractFactory.product.AbstractVideoResource;

import java.io.InputStream;

/**
 * @author 
 * @createTime 2023-05-10
 */
public class ClasspathVideoResource extends AbstractVideoResource {

    public ClasspathVideoResource() {
    }

    public ClasspathVideoResource(String url) {
        super(url);
    }

    @Override
    public InputStream getInputStream() {
        return null;
    }
}
