package pers.czl.architect.designpattern.dynamicProxy.proxy;

import pers.czl.architect.designpattern.dynamicProxy.jdk.ElectricCar;
import pers.czl.architect.designpattern.dynamicProxy.jdk.Rechargable;
import pers.czl.architect.designpattern.dynamicProxy.jdk.Vehicle;

/**
 * @author: daliu
 * @date: 2022-03-29 14:31
 **/
public class ElectricCarProxy implements Rechargable, Vehicle {

    private ElectricCar electricCar;

    public ElectricCarProxy(ElectricCar electricCar) {
        this.electricCar = electricCar;
    }

    @Override
    public void recharge() {
        System.out.println("You are going to invoke recharge...");
        this.electricCar.recharge();
        System.out.println("recharge invocation Has Been finished...");
    }

    @Override
    public void drive() {
        System.out.println("You are going to invoke drive...");
        this.electricCar.drive();
        System.out.println("drive invocation Has Been finished...");
    }

}