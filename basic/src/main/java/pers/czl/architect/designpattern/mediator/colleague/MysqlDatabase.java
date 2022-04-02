package pers.czl.architect.designpattern.mediator.colleague;

import pers.czl.architect.designpattern.mediator.mediator.AbstractMediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: daliu
 * @date: 2022-04-02 10:57
 **/
public class MysqlDatabase extends AbstractDatabase {

    private List<String> dataList = new ArrayList<>();

    public MysqlDatabase(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("mysql添加数据：" + data);
        this.dataList.add(data);
    }

    public void showData() {
        System.out.println("EsDatabase datas:" + this.dataList.toString());
    }

}