package pers.czl.architect.designpattern.proxy;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-11 11:03
 * @Version:1.0
 **/
public class BuyHouseImpl implements BuyHouse {

    @Override
    public void buyHouse() {
        System.out.println("买房子");
    }
}