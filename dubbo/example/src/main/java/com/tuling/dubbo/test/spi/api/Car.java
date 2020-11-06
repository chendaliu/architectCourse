package com.tuling.dubbo.test.spi.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-06 11:28
 * @Version:1.0
 **/
@SPI
public interface Car {

    @Adaptive(value = "carType")
    void getColor(URL url);

}