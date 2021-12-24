package pers.czl.architect.designpattern.factory.simpleFactory.factory;

import pers.czl.architect.designpattern.factory.simpleFactory.product.GeliAirConditioner;
import pers.czl.architect.designpattern.factory.simpleFactory.product.HaierAirConditioner;
import pers.czl.architect.designpattern.factory.simpleFactory.product.IAirConditioner;

/**
 * @author: daliu
 * @date: 2021-12-23 19:17
 **/
public class AirConditionerFactory {

    public static IAirConditioner produce(String args) {
        if ("haier".equals(args)) {
            return new HaierAirConditioner();
        } else if ("geli".equals(args)) {
            return new GeliAirConditioner();
        } else {
            return null;
        }
    }
}
