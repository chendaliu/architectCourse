package com.ydlclass.mediator;

/**
 * @author
 * @createTime 2023-06-04
 */
public class ConcreteMediator implements Mediator {

    // 维护多个同时之间的交互关系
    private Colleague colleague1;
    private Colleague colleague2;

    public void setColleague1(Colleague colleague1) {
        this.colleague1 = colleague1;
    }

    public void setColleague2(Colleague colleague2) {
        this.colleague2 = colleague2;
    }


    @Override
    public void send(String msg, Colleague colleague) {
        // 封装具体的交互逻辑，我们案例的逻辑及其简单就是给对方发送消息
        if(colleague == colleague1){
            colleague2.notifyMe(msg);
        } else {
            colleague1.notifyMe(msg);
        }

    }
}
