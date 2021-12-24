package pers.czl.architect.designpattern.factory.abstractFactory.factory;

import pers.czl.architect.designpattern.factory.abstractFactory.product.IAirConditioner;
import pers.czl.architect.designpattern.factory.abstractFactory.product.IRefrigerator;

/**
 * 电器
 * @author: daliu
 * @date: 2021-12-24 09:42
 **/
public interface IDeviceFactory {

    /**
     * 生产冰箱
     **/
    IRefrigerator produceRefrigerator();

    /**
     * 生产空调
     **/
    IAirConditioner produceAirConditioner();
}