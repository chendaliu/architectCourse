package pers.czl.architect.designpattern.factory.abstractFactory.factory;

import pers.czl.architect.designpattern.factory.abstractFactory.product.HaierAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.HaierRefrigerator;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IRefrigerator;

/**
 * 海尔工厂
 * @author: daliu
 * @date: 2021-12-24 09:47
 **/
public class HaierFactory implements IDeviceFactory {

    @Override
    public IRefrigerator produceRefrigerator() {
        return new HaierRefrigerator();
    }

    @Override
    public IAirConditioner produceAirConditioner() {
        return new HaierAirConditioner();
    }
}