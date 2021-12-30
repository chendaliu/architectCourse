package pers.czl.architect.designpattern.adapter.target;

/**
 * 目标抽象类
 * @author: daliu
 * @date: 2021-12-30 14:42
 **/
public interface ScoreOperation {

    public int[] sort(int array[]); //成绩排序
    public int search(int array[],int key); //成绩查找

}