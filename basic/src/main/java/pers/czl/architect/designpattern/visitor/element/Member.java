package pers.czl.architect.designpattern.visitor.element;

import pers.czl.architect.designpattern.visitor.vistor.Selection;

/**
 * 抽象元素
 * @author: daliu
 * @date: 2022-03-25 16:57
 **/
public abstract class Member {
    public String name;

    public abstract void accept(Selection selection);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}