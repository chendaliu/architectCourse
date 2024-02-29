package com.ydlclass.Iterator;

/**
 * @author
 * @createTime 2023-06-03
 */
public class IntArray {

    private int[] nums;

    public IntArray(int[] nums) {
        this.nums = nums;
    }

    // 暴露一个返回迭代器的方法
    public Iterator iterator(){
        return new IntArrayIterator(this);
    }



    private static class IntArrayIterator implements Iterator{

        IntArray intArray;

        // 需要一个游标
        int index = -1;

        public IntArrayIterator(IntArray intArray) {
            this.intArray = intArray;
        }

        @Override
        public boolean hasNext() {
            index++;
            return index < intArray.nums.length;
        }

        @Override
        public int next() {
            return intArray.nums[index];
        }
    }

}
