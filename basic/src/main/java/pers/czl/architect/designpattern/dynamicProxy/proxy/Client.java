package pers.czl.architect.designpattern.dynamicProxy.proxy;

import pers.czl.architect.designpattern.dynamicProxy.jdk.ElectricCar;
import pers.czl.architect.designpattern.dynamicProxy.jdk.Rechargable;

/**
 * @author: daliu
 * @date: 2022-03-29 14:34
 **/
public class Client {

    public static void main(String[] args) {
        Rechargable rechargable = new ElectricCarProxy(new ElectricCar());
        rechargable.recharge();
    }
}