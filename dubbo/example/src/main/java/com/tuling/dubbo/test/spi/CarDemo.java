package com.tuling.dubbo.test.spi;

import com.tuling.dubbo.test.spi.api.Car;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-06 11:36
 * @Version:1.0
 **/
public class CarDemo {

    public static void main(String[] args) {
        ExtensionLoader<Car> extensionLoader = ExtensionLoader.getExtensionLoader(Car.class);
        Car redCar = extensionLoader.getExtension("red");
        redCar.getColor(null);
    }

}