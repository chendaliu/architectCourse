package com.ydlclass.observer.subscriber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @createTime 2023-05-30
 */
public class EventBus {

    // 维护事件（对象，字符串）和订阅者的关系
    Map<String, List<Subscriber>> subscribers = new HashMap<>(8);

    public void registerSubscriber(String eventType,Subscriber subscriber){
        // 通过事件来确定有没有订阅者
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>());
        // 获取订阅者集合
        List<Subscriber> sbbs = subscribers.get(eventType);
        // 注册
        sbbs.add(subscriber);
    }

    public void removeSubscriber(String eventType,Subscriber subscriber){
        List<Subscriber> sbbs = subscribers.get(eventType);
        if(sbbs != null){
            sbbs.remove(subscriber);
        }
    }

    public void publishEvent(String eventType,Map<String,Object> eventContext){
        List<Subscriber> sbbs = subscribers.get(eventType);
        for (Subscriber sbb : sbbs) {
            sbb.onEvent(eventContext);
        }
    }

}
