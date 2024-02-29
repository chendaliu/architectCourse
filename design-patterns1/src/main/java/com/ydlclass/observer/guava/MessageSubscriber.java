package com.ydlclass.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @author 
 * @createTime 2023-05-31
 */
public class MessageSubscriber {
    @Subscribe
    public void handleMessageEvent(MessageEvent event) {
        System.out.println("收到消息: " + event.getMessage());
    }
}
