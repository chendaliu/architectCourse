package com.ydlclass.observer.spring;

import org.springframework.context.ApplicationEvent;

/**
 * @author
 * @createTime 2023-05-31
 */
public class TemperatureChangeApplicationEvent extends ApplicationEvent {

    public TemperatureChangeApplicationEvent(Float newTemperature) {
        super(newTemperature);
    }
}
