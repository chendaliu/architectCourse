package com.tuling.dubbo.test.spi.impl;

import com.tuling.dubbo.test.spi.api.Car;
import com.tuling.dubbo.test.spi.api.Driver;
import org.apache.dubbo.common.URL;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-06 11:38
 * @Version:1.0
 **/
public class Trucker implements Driver {

    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void driveCar(URL url) {
        car.getColor(url);
    }
}