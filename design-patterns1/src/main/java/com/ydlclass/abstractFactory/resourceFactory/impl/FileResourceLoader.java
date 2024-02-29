package com.ydlclass.abstractFactory.resourceFactory.impl;

import com.ydlclass.abstractFactory.product.AbstractPictureResource;
import com.ydlclass.abstractFactory.product.AbstractTextResource;
import com.ydlclass.abstractFactory.product.AbstractVideoResource;
import com.ydlclass.abstractFactory.resourceFactory.AbstractResourceLoader;

/**
 * @author
 * @createTime 2023-05-09
 */
public class FileResourceLoader extends AbstractResourceLoader {

    @Override
    public AbstractPictureResource loadPictureResource(String url) {
        return null;
    }

    @Override
    public AbstractVideoResource loadVideoResource(String url) {
        return null;
    }

    @Override
    public AbstractTextResource loadTestResource(String url) {
        return null;
    }
}
