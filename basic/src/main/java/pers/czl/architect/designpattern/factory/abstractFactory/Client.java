package pers.czl.architect.designpattern.factory.abstractFactory;

import pers.czl.architect.designpattern.factory.abstractFactory.factory.GeliFactory;
import pers.czl.architect.designpattern.factory.abstractFactory.factory.HaierFactory;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IRefrigerator;

/**
 * 抽象工厂
 *
 * 【产品等级】和【产品族】
 * 假如有4个产品：海尔冰箱、海尔空调、格力冰箱、格力空调
 * 产品等级：冰箱包含海尔冰箱和格力冰箱
 * 产品族：海尔生产海尔冰箱、海尔空调
 * @author: daliu
 * @date: 2021-12-23 19:30
 **/
public class Client {

    public static void main(String[] args) {
        //生产格力空调
        IAirConditioner haierAirConditioner = new HaierFactory().produceAirConditioner();
        haierAirConditioner.work();

        IRefrigerator geliRefrigerator = new GeliFactory().produceRefrigerator();
        geliRefrigerator.work();
    }
}