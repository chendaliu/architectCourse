package com.ydlclass.mediator;

/**
 * @author 
 * @createTime 2023-06-04
 */
public abstract class Colleague {

    protected Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    abstract void send(String msg);

    abstract void notifyMe(String msg);

}
