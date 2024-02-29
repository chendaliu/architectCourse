package com.ydlclass.abstractFactory.resourceFactory;

import com.ydlclass.abstractFactory.product.AbstractPictureResource;
import com.ydlclass.abstractFactory.product.AbstractTextResource;
import com.ydlclass.abstractFactory.product.AbstractVideoResource;

/**
 * IResourceFactory,每一个工厂实例，都可以生产一个产品族
 * @author 
 * @createTime 2023-05-09
 */
public interface IResourceLoader {

    /**
     * 加载图片资源的工厂方法
     * @param url 给定的资源url
     * @return 图片资源
     */
    AbstractPictureResource loadPictureResource(String url);

    /**
     * 加载视频资源的工厂方法
     * @param url 给定的资源url
     * @return 视频资源
     */
    AbstractVideoResource loadVideoResource(String url);

    /**
     * 加载文本资源的工厂方法
     * @param url 给定的资源url
     * @return 文本资源
     */
    AbstractTextResource loadTestResource(String url);
}
