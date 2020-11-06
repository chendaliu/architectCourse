package com.tuling.dubbo.test.spi.impl;

import com.tuling.dubbo.test.spi.api.Car;
import org.apache.dubbo.common.URL;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-06 11:33
 * @Version:1.0
 **/
public class BlackCar implements Car {

    @Override
    public void getColor(URL url) {
        System.out.println("black");
    }
}