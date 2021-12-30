package pers.czl.architect.designpattern.adapter.adaptee;

/**
 * 适配者类2，假设是一个未开源的搜索算法
 *
 * @author: daliu
 * @date: 2021-12-30 14:37
 **/
public class BinarySearch {

    public int binarySearch(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                return 1; //找到元素返回1
            }
        }
        return -1;  //未找到元素返回-1
    }

}