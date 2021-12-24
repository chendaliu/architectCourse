package pers.czl.architect.designpattern.factory.factoryMethod.factory;

import pers.czl.architect.designpattern.factory.simpleFactory.product.IAirConditioner;

/**
 * @author: daliu
 * @date: 2021-12-23 19:17
 **/
public interface AirConditionerFactory {

    IAirConditioner produce();
}
