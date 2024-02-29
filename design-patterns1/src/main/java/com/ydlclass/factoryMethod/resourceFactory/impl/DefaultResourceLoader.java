package com.ydlclass.factoryMethod.resourceFactory.impl;

import com.ydlclass.factoryMethod.resourceFactory.IResourceLoader;
import com.ydlclass.simpleFactory.Resource;

/**
 * @author
 * @createTime 2023-05-09
 */
public class DefaultResourceLoader implements IResourceLoader {
    @Override
    public Resource load(String url) {
        // 中间省略复杂的创建过程
        return new Resource(url);
    }
}
