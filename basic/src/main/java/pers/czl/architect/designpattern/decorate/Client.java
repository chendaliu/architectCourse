package pers.czl.architect.designpattern.decorate;

/**
 * @Title: 装饰模式
 * @Description: 装饰模式角色：抽象组件，抽象装饰者，具体组件，具体装饰者 <br>
 *     跟代理模式有点像。代理模式是让别人做我不关心的事。装饰模式是让自己变得更强
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-10 20:23
 * @Version:1.0
 **/
public class Client {

    public static void main(String[] args) {
        AbstractComponent component = new ConcreteComponent();
        component = new ConcreteDecoratorA(component);
        component = new ConcreteDecoratorB(component);

        component.operation();
    }
}