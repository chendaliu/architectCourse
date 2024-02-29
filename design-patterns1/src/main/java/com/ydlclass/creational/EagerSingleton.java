package com.ydlclass.creational;

/**
 * 饿汉式单例的实现
 * @author 
 * @createTime 2023-05-08
 */
public class EagerSingleton {

    /**
     * 1、创建对象本身的复杂度
     * 很多的单例对象创建的过程可能及其复杂、
     * 很多单例对象创建完成后会占用很大内存，比如缓存对象
     * 很多单例对象创建完成后可能很小且很简单
     */

    // 1、 持有一个jvm全局唯一的实例
    private final static EagerSingleton instance = new EagerSingleton();

    // 2、为了避免别人随意的创建，我们需要私有化构造器
    private EagerSingleton(){}

    // 3、暴露一个方法，用来获取实例
    public static EagerSingleton getInstance() {
        return instance;
    }
}
