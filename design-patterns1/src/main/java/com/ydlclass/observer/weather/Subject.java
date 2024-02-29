package com.ydlclass.observer.weather;

/**
 * 被观察者应该提供，注册，删除，通知观察者的能力
 * @author
 * @createTime 2023-05-30
 */
public interface Subject {

    /**
     * 注册观察者的能力
     * @param observer 注册的观察者
     */
    void registerObserver(Observer observer);

    /**
     * 删除一个具体的观察者
     * @param observer 删除的观察者
     */
    void removeObserver(Observer observer);

    /**
     * 一旦发生了观察的行为，应该通知所有的观察者
     */
    void notifyObservers(float newTemperature);

}
