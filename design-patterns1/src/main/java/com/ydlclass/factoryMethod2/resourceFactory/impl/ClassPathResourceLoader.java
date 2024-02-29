package com.ydlclass.factoryMethod2.resourceFactory.impl;

import com.ydlclass.factoryMethod2.product.AbstractResource;
import com.ydlclass.factoryMethod2.product.impl.ClasspathResource;
import com.ydlclass.factoryMethod2.resourceFactory.IResourceLoader;

/**
 * @author 
 * @createTime 2023-05-09
 */
public class ClassPathResourceLoader implements IResourceLoader {
    @Override
    public AbstractResource load(String url) {
        // 中间省略复杂的创建过程
        return new ClasspathResource(url);
    }
}
