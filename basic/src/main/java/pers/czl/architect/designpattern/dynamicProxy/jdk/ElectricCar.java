package pers.czl.architect.designpattern.dynamicProxy.jdk;

/**
 * 电能车类，实现Rechargable，Vehicle接口
 * @author
 */
public class ElectricCar implements Rechargable, Vehicle {

    @Override
    public void drive() {
        System.out.println("Electric Car is Moving silently...");
    }

    @Override
    public void recharge() {
        System.out.println("Electric Car is Recharging...");
    }

}