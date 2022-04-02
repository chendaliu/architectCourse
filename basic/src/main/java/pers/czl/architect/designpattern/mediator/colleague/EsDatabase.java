package pers.czl.architect.designpattern.mediator.colleague;

import pers.czl.architect.designpattern.mediator.mediator.AbstractMediator;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: daliu
 * @date: 2022-04-02 10:54
 **/
public class EsDatabase extends AbstractDatabase {

    private Set<String> dataSet = new HashSet<>();

    public EsDatabase(AbstractMediator abstractMediator) {
        super(abstractMediator);
    }

    @Override
    public void addData(String data) {
        System.out.println("es添加数据：" + data);
        this.dataSet.add(data);
    }

    public void showData() {
        System.out.println("EsDatabase datas:" + this.dataSet.toString());
    }
}