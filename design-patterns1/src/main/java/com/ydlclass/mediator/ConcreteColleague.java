package com.ydlclass.mediator;

/**
 * @author 
 * @createTime 2023-06-04
 */
public class ConcreteColleague extends Colleague{

    private String name;

    public ConcreteColleague(Mediator mediator,String name) {
        super(mediator);
        this.name = name;
    }

    @Override
    void send(String msg) {
        // 自己不能发消息
        mediator.send(msg,this);
    }

    @Override
    void notifyMe(String msg) {
        // 具体的接收到消息后，需要完成的逻辑
        System.out.println(name + "----> 收到了通知【" + msg + "】。");
    }
}
