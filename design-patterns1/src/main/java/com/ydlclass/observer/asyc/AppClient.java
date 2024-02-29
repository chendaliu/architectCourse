package com.ydlclass.observer.asyc;

/**
 * @author
 * @createTime 2023-05-30
 */
public class AppClient implements Observer {
    @Override
    public void update(float newTemperature) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("app 更新了温度，现在的温度是：" + newTemperature);
    }
}
