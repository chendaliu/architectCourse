package pers.czl.architect.designpattern.decorate;

import pers.czl.architect.designpattern.decorate.component.AbstractComponent;
import pers.czl.architect.designpattern.decorate.component.ConcreteComponent;
import pers.czl.architect.designpattern.decorate.decorator.ConcreteDecoratorA;
import pers.czl.architect.designpattern.decorate.decorator.ConcreteDecoratorB;

/**
 * 装饰模式
 * 角色：
 * 1.Component（抽象组件）
 * 2.具体组件（ConcreteComponent）
 * 3.抽象装饰者（Decorator）
 * 4.具体装饰者（具体装饰类）
 *
 * 描述：动态的给一个对象添加一些额外的职责
 * 跟代理模式有点像。代理模式是让别人做我不关心的事。装饰模式是让自己变得更强
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