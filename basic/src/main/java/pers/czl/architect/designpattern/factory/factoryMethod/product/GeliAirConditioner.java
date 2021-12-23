package pers.czl.architect.designpattern.factory.factoryMethod.product;

/**
 * @author: daliu
 * @date: 2021-12-23 19:17
 **/
public class GeliAirConditioner implements IAirConditioner {

    @Override
    public void work() {
        System.out.println("格力空调开始工作");
    }
}