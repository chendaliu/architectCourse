package pers.czl.architect.designpattern.factory.abstractFactory.product;

/**
 * @author: daliu
 * @date: 2021-12-24 09:41
 **/
public class GeliRefrigerator implements IRefrigerator {

    @Override
    public void work() {
        System.out.println("格力冰箱开始工作");
    }
}