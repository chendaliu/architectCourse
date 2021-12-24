package pers.czl.architect.designpattern.factory.abstractFactory;

import pers.czl.architect.designpattern.factory.abstractFactory.factory.GeliFactory;
import pers.czl.architect.designpattern.factory.abstractFactory.factory.HaierFactory;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IRefrigerator;

/**
 * 抽象工厂
 *
 * 【产品等级结构】和【产品族】
 * 假如有4个产品：海尔冰箱、海尔空调、格力冰箱、格力空调
 * 产品等级结构：冰箱包含海尔冰箱和格力冰箱
 * 产品族：海尔生产海尔冰箱、海尔空调
 *
 * 如果使用工厂方法，需要4个工厂.使用抽象工厂，只需要两个工厂，把同一产品组的产品放入同一个工厂
 *
 * 缺陷：增加一个产品族的时候只需要增加一个工厂，但是增加产品的产品等级的时候却需要修改抽象工厂和所有具体工厂，违背开闭原则，
 * 因此在设计时需要全面考虑，不会在设计完成之后增加新的产品等级结构
 * @author: daliu
 * @date: 2021-12-23 19:30
 **/
public class Client {

    public static void main(String[] args) {
        //生产海尔空调
        IAirConditioner haierAirConditioner = new HaierFactory().produceAirConditioner();
        haierAirConditioner.work();

        //生产格力冰箱
        IRefrigerator geliRefrigerator = new GeliFactory().produceRefrigerator();
        geliRefrigerator.work();
    }
}