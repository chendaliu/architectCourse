package com.ydlclass.creational;

import java.io.Serializable;

/**
 * 双重检查锁单例的实现
 * @author 
 * @createTime 2023-05-08
 */
public class DclSingleton implements Serializable {

    // 1、 持有一个jvm全局唯一的实例
    // 创建对象，不是一个原子性操作，即使使用了双重检查锁，也课程在创建的过程中产生半初始化状态
    // volatile 1、保证内存可见   2、保证有序性
    // 事实上，1.9以上，不加volatile也可以，jvm内部处理有序性
    private static volatile DclSingleton instance ;

    // 2、为了避免别人随意的创建，我们需要私有化构造器
    private DclSingleton(){
        // 升级的版本--》不要让人使用反射创建
        if( instance != null ){
            throw new RuntimeException("该对象是单例的，无法创建多个");
        }
    }

    // 3、暴露一个方法，用来获取实例
    // 第一次创建需要双锁，一旦创建好了，就不在需要上锁，
    // 事实上，获取单例并没有线程安全的问题
    public static DclSingleton getInstance() {
        if (null == instance) {
            synchronized (DclSingleton.class) {
                if(null == instance) {
                    instance = new DclSingleton();
                }
            }
        }
        return instance;
    }

    public Object readResolve(){
        return instance;
    }
}
