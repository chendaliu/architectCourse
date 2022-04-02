package pers.czl.architect.designpattern.mediator.mediator;

import pers.czl.architect.designpattern.mediator.colleague.AbstractDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象中介者类
 * @author: daliu
 * @date: 2022-04-02 10:27
 **/
public abstract class AbstractMediator {

    protected List<AbstractDatabase> databaseList = new ArrayList<>();

    public abstract void sync(AbstractDatabase database, String data);

    public void regist(AbstractDatabase abstractDatabase) {
        this.databaseList.add(abstractDatabase);
    }

    public void regist(List<AbstractDatabase> abstractDatabaseList) {
        this.databaseList.addAll(abstractDatabaseList);
    }

    public void showDatas() {
        this.databaseList.forEach(db -> {
            System.out.print(db.getClass() + ":");
            db.showData();
        });
    }
}