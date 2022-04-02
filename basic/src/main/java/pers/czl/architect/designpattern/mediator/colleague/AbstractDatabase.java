package pers.czl.architect.designpattern.mediator.colleague;

import pers.czl.architect.designpattern.mediator.mediator.AbstractMediator;

import java.util.List;

/**
 * 抽象数据库 - 抽象同事类
 * @author: daliu
 * @date: 2022-04-02 10:17
 **/
public abstract class AbstractDatabase {

    public AbstractDatabase(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
    }

    public abstract void addData(String data);

    public void add(String data) {
        this.addData(data);
        this.abstractMediator.sync(this, data);
    }

    protected AbstractMediator abstractMediator;


    public AbstractMediator getAbstractMediator() {
        return abstractMediator;
    }

    public void setAbstractMediator(AbstractMediator abstractMediator) {
        this.abstractMediator = abstractMediator;
    }

    public void showData() {

    }
}