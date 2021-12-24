package pers.czl.architect.designpattern.factory.simpleFactory;

import pers.czl.architect.designpattern.factory.simpleFactory.factory.AirConditionerFactory;
import pers.czl.architect.designpattern.factory.simpleFactory.product.IAirConditioner;

/**
 * 简单工厂模式
 * 缺陷：1.以后加日志种类，就要修改工厂类，违背开闭原则
 * 2.日志种类太多的时候，工厂类职责太重。
 * 解决办法：工厂方法模式
 * @author: daliu
 * @date: 2021-12-23 17:37
 **/
public class Client {

    public static void main(String[] args) {
        IAirConditioner haier = AirConditionerFactory.produce("haier");
        haier.work();

        IAirConditioner geli = AirConditionerFactory.produce("geli");
        geli.work();
    }
}