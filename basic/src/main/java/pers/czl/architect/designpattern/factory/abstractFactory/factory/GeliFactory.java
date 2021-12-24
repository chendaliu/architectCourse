package pers.czl.architect.designpattern.factory.abstractFactory.factory;

import pers.czl.architect.designpattern.factory.abstractFactory.product.GeliAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.GeliRefrigerator;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IRefrigerator;

/**
 * 格力工厂
 * @author: daliu
 * @date: 2021-12-24 09:48
 **/
public class GeliFactory implements IDeviceFactory {

    @Override
    public IRefrigerator produceRefrigerator() {
        return new GeliRefrigerator();
    }

    @Override
    public IAirConditioner produceAirConditioner() {
        return new GeliAirConditioner();
    }
}