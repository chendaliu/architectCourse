package pers.czl.architect.designpattern.factory.abstractFactory.product;

/**
 * @author: daliu
 * @date: 2021-12-24 09:41
 **/
public class HaierRefrigerator implements IRefrigerator {

    @Override
    public void work() {
        System.out.println("海尔冰箱开始工作");
    }
}