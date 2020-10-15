package pers.czl.architect.designpattern.proxy;

/**
 * @Title: 代理模式
 * @Description: 角色：代理类、委托类、接口
 * 代理模式跟装饰模式有点像，代理模式是别人做我不关心的事，装饰模式是让自己更强
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-11 11:06
 * @Version:1.0
 **/
public class Client {

    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();

        ByHouseProxy proxy = new ByHouseProxy(buyHouse);
        proxy.buyHouse();
    }
}