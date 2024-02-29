package com.ydlclass.observer.spring;

import org.springframework.context.ApplicationListener;

/**
 * @author
 * @createTime 2023-05-31
 */
public class AppListener implements ApplicationListener<TemperatureChangeApplicationEvent> {
    @Override
    public void onApplicationEvent(TemperatureChangeApplicationEvent event) {
        System.out.println("app -->温度发生了该表--》" + event.getSource());
    }
}
