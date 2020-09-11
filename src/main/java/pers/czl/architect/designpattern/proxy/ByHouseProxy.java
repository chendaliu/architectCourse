package pers.czl.architect.designpattern.proxy;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-11 11:03
 * @Version:1.0
 **/
public class ByHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public ByHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        buyHouse.buyHouse();
        this.decorate();
    }

    private void decorate() {
        System.out.println("装修房子");
    }
}