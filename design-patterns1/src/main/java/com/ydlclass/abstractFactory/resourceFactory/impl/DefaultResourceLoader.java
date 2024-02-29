package com.ydlclass.abstractFactory.resourceFactory.impl;

import com.ydlclass.abstractFactory.product.AbstractPictureResource;
import com.ydlclass.abstractFactory.product.AbstractTextResource;
import com.ydlclass.abstractFactory.product.AbstractVideoResource;
import com.ydlclass.abstractFactory.product.impl.DefaultPictureResource;
import com.ydlclass.abstractFactory.product.impl.DefaultTestResource;
import com.ydlclass.abstractFactory.product.impl.DefaultVideoResource;
import com.ydlclass.abstractFactory.resourceFactory.AbstractResourceLoader;

/**
 * @author 
 * @createTime 2023-05-09
 */
public class DefaultResourceLoader extends AbstractResourceLoader {

    @Override
    public AbstractPictureResource loadPictureResource(String url) {
        return new DefaultPictureResource(url);
    }

    @Override
    public AbstractVideoResource loadVideoResource(String url) {
        return new DefaultVideoResource(url);
    }

    @Override
    public AbstractTextResource loadTestResource(String url) {
        return new DefaultTestResource(url);
    }
}
