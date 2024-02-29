package com.ydlclass.observer.subscriber;

import java.util.Map;

/**
 * @author 
 * @createTime 2023-05-30
 */
public class AppSubscriber implements Subscriber{
    @Override
    public void onEvent(Map<String,Object> eventContext) {
        System.out.println("app -> 当前的温度是：" + eventContext.get("temp"));
    }
}
