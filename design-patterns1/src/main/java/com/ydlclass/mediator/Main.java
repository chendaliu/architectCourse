package com.ydlclass.mediator;

/**
 * @author 
 * @createTime 2023-06-04
 */
public class Main {
    public static void main(String[] args) {
        // 1、创建中介者
        ConcreteMediator mediator = new ConcreteMediator();

        // 2、创建需要发消息的同事
        Colleague colleague1 = new ConcreteColleague(mediator,"colleague1");
        Colleague colleague2 = new ConcreteColleague(mediator,"colleague2");

        mediator.setColleague1(colleague1);
        mediator.setColleague2(colleague2);

        // 3、测试
        colleague1.send("hello");

        colleague2.send("world");

    }
}
