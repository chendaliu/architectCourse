package com.tuling.dubbo.test.spi.impl;

import com.tuling.dubbo.test.spi.api.Car;
import org.apache.dubbo.common.URL;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-06 11:34
 * @Version:1.0
 **/
public class CarWrapper implements Car {

    private Car car;

    public CarWrapper(Car car) {
        this.car = car;
    }

    @Override
    public void getColor(URL url) {
        System.out.println("before");
        car.getColor(url);
        System.out.println("after");
    }
}