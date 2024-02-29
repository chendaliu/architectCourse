package com.ydlclass.factoryMethod.resourceFactory;

import com.ydlclass.simpleFactory.Resource;

/**
 * IResourceFactory
 * @author
 * @createTime 2023-05-09
 */
public interface IResourceLoader {
    Resource load(String url);
}
