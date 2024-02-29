package com.ydlclass.simpleFactory;

/**
 * @author 
 * @createTime 2023-05-09
 */
public class ResourceLoadException extends RuntimeException{

    public ResourceLoadException() {
        super("加载资源是发生问题。");
    }

    public ResourceLoadException(String message) {
        super(message);
    }
}
