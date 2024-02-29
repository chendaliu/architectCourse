package com.ydlclass.observer.weather;

/**
 * @author
 * @createTime 2023-05-30
 */
public class WebClient implements Observer{
    @Override
    public void update(float newTemperature) {
        System.out.println("网站 更新了温度，现在的温度是：" + newTemperature);
    }
}
