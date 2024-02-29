package com.ydlclass.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @author 
 * @createTime 2023-05-31
 */
public class Main {
    public static void main(String[] args) {
        // 创建 EventBus 实例
        EventBus eventBus = new EventBus();

        // 创建并注册订阅者
        MessageSubscriber subscriber = new MessageSubscriber();
        eventBus.register(subscriber);

        // 发布事件
        eventBus.post(new MessageEvent("Hello, EventBus!"));

        System.out.println("---------------------");

        // 取消注册订阅者
        eventBus.unregister(subscriber);

        // 再次发布事件（此时订阅者已取消注册，将不会收到消息）
        eventBus.post(new MessageEvent("Another message"));
    }
}
