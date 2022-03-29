package pers.czl.architect.designpattern.iterator.aggregate;

import pers.czl.architect.designpattern.iterator.iterator.AbstractIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象聚合类
 * @author: daliu
 * @date: 2022-03-29 16:47
 **/
public abstract class AbstractObjectList {

    protected List<Object> objects;

    public AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object obj) {
        this.objects.add(obj);
    }

    public void removeObject(Object obj) {
        this.objects.remove(obj);
    }

    public List<Object> getObjects() {
        return this.objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();

}
