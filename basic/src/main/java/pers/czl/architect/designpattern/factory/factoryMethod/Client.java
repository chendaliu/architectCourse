package pers.czl.architect.designpattern.factory.factoryMethod;

import pers.czl.architect.designpattern.factory.factoryMethod.factory.GeliAirConditionerFactory;
import pers.czl.architect.designpattern.factory.factoryMethod.factory.HaierAirConditionerFactory;
import pers.czl.architect.designpattern.factory.simpleFactory.product.IAirConditioner;

/**
 * 工厂方法模式，定义一个抽象工厂类，每个产品对应一个具体工厂进行创建
 * 角色：抽象工厂、具体工厂、抽象产品、具体产品
 * 缺陷：1.产品太多的时候，工厂类也会太多，增加系统开销，比如有4个产品：海尔冰箱、海尔空调、格力冰箱、格力空调，就要4个工厂
 *
 * 解决：使用抽象工厂，可以将相关的产品组成一个“产品族”，例如海尔工厂生产海尔冰箱、海尔空调，格力工厂也生产海尔冰箱、空调
 *
 * @author: daliu
 * @date: 2021-12-23 17:46
 **/
public class Client {

    public static void main(String[] args) {
        IAirConditioner haier = new HaierAirConditionerFactory().produce();
        haier.work();

        IAirConditioner geli = new GeliAirConditionerFactory().produce();
        geli.work();
    }
}