package pers.czl.architect.designpattern.composite.component;

/**
 * 抽象构件
 * @author: daliu
 * @date: 2021-12-31 13:52
 **/
public abstract class AbstractFile {

    public abstract void add(AbstractFile file);

    public abstract void remove(AbstractFile file);

    public abstract AbstractFile getChild(int i);

    public abstract void killVirus();

}