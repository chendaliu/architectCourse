package com.ydlclass.observer.subscriber;

import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @createTime 2023-05-30
 */
public class WeatherStation {

    private float temperature;

    private EventBus eventBus;

    public WeatherStation(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void changeTemperature(float newTemperature){
        this.temperature = newTemperature;
        Map<String,Object> eventContext = new HashMap<>(2);
        eventContext.put("temp",Float.valueOf(newTemperature));
        eventBus.publishEvent("changeTemperature",eventContext);
    }

    public static void main(String[] args) {
        // 创建订阅者
        AppSubscriber appSubscriber = new AppSubscriber();
        WebSubscriber webSubscriber = new WebSubscriber();

        // 构建消息总线
        EventBus bus = new EventBus();
        bus.registerSubscriber("changeTemperature",appSubscriber);
        bus.registerSubscriber("changeTemperature",webSubscriber);

        // 创建气象站
        WeatherStation weatherStation = new WeatherStation(bus);
        weatherStation.changeTemperature(36.9F);



    }

}
