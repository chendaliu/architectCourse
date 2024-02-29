package com.ydlclass.abstractFactory.resourceFactory.impl;

import com.ydlclass.abstractFactory.product.AbstractPictureResource;
import com.ydlclass.abstractFactory.product.AbstractTextResource;
import com.ydlclass.abstractFactory.product.AbstractVideoResource;
import com.ydlclass.abstractFactory.product.impl.ClasspathPictureResource;
import com.ydlclass.abstractFactory.product.impl.ClasspathTestResource;
import com.ydlclass.abstractFactory.product.impl.ClasspathVideoResource;
import com.ydlclass.abstractFactory.resourceFactory.AbstractResourceLoader;

/**
 * @author 
 * @createTime 2023-05-09
 */
public class ClassPathResourceLoader extends AbstractResourceLoader {

    @Override
    public AbstractPictureResource loadPictureResource(String url) {
        return new ClasspathPictureResource(url);
    }

    @Override
    public AbstractVideoResource loadVideoResource(String url) {
        return new ClasspathVideoResource(url);
    }

    @Override
    public AbstractTextResource loadTestResource(String url) {
        return new ClasspathTestResource(url);
    }
}
