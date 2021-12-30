package pers.czl.architect.designpattern.adapter.adapter;

import pers.czl.architect.designpattern.adapter.adaptee.BinarySearch;
import pers.czl.architect.designpattern.adapter.adaptee.QuickSort;
import pers.czl.architect.designpattern.adapter.target.ScoreOperation;

/**
 * 适配器类，闭源的两个算法没法使用，需要适配器做转换
 * @author: daliu
 * @date: 2021-12-30 14:40
 **/
public class OperationAdapter implements ScoreOperation {

    //定义适配者QuickSort对象
    private QuickSort sortObj;

    //定义适配者BinarySearch对象
    private BinarySearch searchObj;

    public OperationAdapter() {
        this.sortObj = new QuickSort();
        this.searchObj = new BinarySearch();
    }

    @Override
    public int[] sort(int[] array) {
        return this.sortObj.quickSort(array);
    }

    @Override
    public int search(int[] array, int key) {
        return this.searchObj.binarySearch(array, key);
    }
}