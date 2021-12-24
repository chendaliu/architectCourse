package pers.czl.architect.designpattern.factory.factoryMethod.factory;

import pers.czl.architect.designpattern.factory.simpleFactory.product.GeliAirConditioner;
import pers.czl.architect.designpattern.factory.simpleFactory.product.IAirConditioner;

/**
 * @author: daliu
 * @date: 2021-12-23 19:26
 **/
public class GeliAirConditionerFactory implements AirConditionerFactory {

    @Override
    public IAirConditioner produce() {
        return new GeliAirConditioner();
    }
}