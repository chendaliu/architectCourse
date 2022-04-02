package pers.czl.architect.designpattern.mediator.colleague;

import pers.czl.architect.designpattern.mediator.mediator.AbstractMediator;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: daliu
 * @date: 2022-04-02 10:49
 **/
public class RedisDatabase extends AbstractDatabase {

    private List<String> dataList = new CopyOnWriteArrayList();

    public RedisDatabase(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("redis添加数据：" + data);
        this.dataList.add(data);
    }

    public void showData() {
        System.out.println("EsDatabase datas:" + this.dataList.toString());
    }
}