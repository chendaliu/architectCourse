package com.ydlclass.observer.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @createTime 2023-05-30
 */
public class WeatherStation implements Subject{

    // 温度
    private float temperature;

    // 持有多个观察者
    private List<Observer> observers = new ArrayList<>();

    public void changeTemperature(float newTemperature){
        this.temperature = newTemperature;
        notifyObservers(newTemperature);

    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(float newTemperature) {
        for (Observer observer : observers) {
            observer.update(newTemperature);
        }
    }
}
