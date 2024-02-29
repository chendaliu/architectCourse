package com.ydlclass.observer.subscriber;

import java.util.Map;

/**
 * @author
 * @createTime 2023-05-30
 */
public class WebSubscriber implements Subscriber{
    @Override
    public void onEvent(Map<String,Object> eventContext) {
        System.out.println("web -> 当前的温度是：" + eventContext.get("temp"));
    }
}
