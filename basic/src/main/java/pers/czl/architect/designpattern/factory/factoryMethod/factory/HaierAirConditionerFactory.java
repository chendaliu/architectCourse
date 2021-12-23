package pers.czl.architect.designpattern.factory.factoryMethod.factory;

import pers.czl.architect.designpattern.factory.simpleFactory.product.HaierAirConditioner;
import pers.czl.architect.designpattern.factory.simpleFactory.product.IAirConditioner;

/**
 * @author: daliu
 * @date: 2021-12-23 19:24
 **/
public class HaierAirConditionerFactory implements AirConditionerFactory {

    @Override
    public IAirConditioner product() {
        return new HaierAirConditioner();
    }
}