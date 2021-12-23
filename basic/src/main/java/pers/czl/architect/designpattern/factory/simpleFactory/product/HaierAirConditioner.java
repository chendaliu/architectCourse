package pers.czl.architect.designpattern.factory.simpleFactory.product;

/**
 * @author: daliu
 * @date: 2021-12-23 19:15
 **/
public class HaierAirConditioner implements IAirConditioner {

    @Override
    public void work() {
        System.out.println("海尔空调开始工作");
    }
}