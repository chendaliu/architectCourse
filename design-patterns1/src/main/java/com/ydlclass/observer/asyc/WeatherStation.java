package com.ydlclass.observer.asyc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author 
 * @createTime 2023-05-30
 */
public class WeatherStation implements Subject {

    // 温度
    private float temperature;

    private ExecutorService executorService;

    public WeatherStation(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public WeatherStation() {
    }

    // 持有多个观察者
    private List<Observer> observers = new ArrayList<>();

    public void changeTemperature(float newTemperature) {
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

        // 这里产生的阻塞
        for (Observer observer : observers) {
            if (executorService == null) {
                observer.update(newTemperature);
            } else {
                // 如果传递了线程池，就异步通知
                executorService.execute(() -> observer.update(newTemperature));
            }
        }

    }
}
