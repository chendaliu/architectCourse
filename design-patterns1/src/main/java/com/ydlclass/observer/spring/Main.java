package com.ydlclass.observer.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

import java.util.concurrent.Executors;

/**
 * @author 
 * @createTime 2023-05-31
 */
public class Main {

    public static void main(String[] args) {

        // 1、创建一个多播器
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(Executors.newFixedThreadPool(5));

        // 2、定义一个事件
        ApplicationEvent event = new TemperatureChangeApplicationEvent(25.6F);

        // 3、注册观察者
        multicaster.addApplicationListener(new AppListener());
        multicaster.addApplicationListener(new WebListener());

        // 4、广播事件
        multicaster.multicastEvent(event);
    }

}
