package pers.czl.architect.designpattern.iterator.iterator;

/**
 * 抽象迭代器
 * @author: daliu
 * @date: 2022-03-29 16:46
 **/
public interface AbstractIterator {
    public void next(); //移至下一个元素
    public boolean isLast(); //判断是否为最后一个元素
    public void previous(); //移至上一个元素
    public boolean isFirst(); //判断是否为第一个元素
    public Object getNextItem(); //获取下一个元素
    public Object getPreviousItem(); //获取上一个元素
}
