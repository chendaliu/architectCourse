package pers.czl.elsetest.spi.impl;

import pers.czl.elsetest.spi.Robot;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-11-05 11:11
 * @Version:1.0
 **/
public class Bumblebee implements Robot {

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Bumblebee.");
    }

}