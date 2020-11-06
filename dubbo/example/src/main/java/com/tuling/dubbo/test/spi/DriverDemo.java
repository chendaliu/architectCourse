package com.tuling.dubbo.test.spi;

import com.tuling.dubbo.test.spi.api.Car;
import com.tuling.dubbo.test.spi.api.Driver;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-06 13:49
 * @Version:1.0
 **/
public class DriverDemo {

    public static void main(String[] args) {
        ExtensionLoader<Driver> extensionLoader = ExtensionLoader.getExtensionLoader(Driver.class);
        Driver driver = extensionLoader.getExtension("trucker");

        Map<String, String> map = new HashMap<>();
        map.put("carType", "red");
        URL url = new URL("", "", 0, map);
        driver.driveCar(url);
    }
}