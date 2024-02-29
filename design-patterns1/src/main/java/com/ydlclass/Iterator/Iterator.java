package com.ydlclass.Iterator;

/**
 * @author
 * @createTime 2023-06-03
 */
public interface Iterator {

    /**
     * 判断有没有下一个
     * @return true 有 false 没有
     */
    boolean hasNext();

    /**
     * 获取当前的值
     * @return 当前的值
     */
    int next();

}
