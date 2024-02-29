package com.ydlclass.observer.weather;

/**
 * @author 
 * @createTime 2023-05-30
 */
public class Main {

    public static void main(String[] args) {
        // 定义气象站
        Subject weatherStation = new WeatherStation();

        // 定义观察者客户端
        Observer appClient = new AppClient();
        Observer webClient = new WebClient();

        // 建立监听关系
        weatherStation.registerObserver(appClient);
        weatherStation.registerObserver(webClient);

        // 气象站就可以更新温度了
        weatherStation.notifyObservers(25.4F);

    }

}
