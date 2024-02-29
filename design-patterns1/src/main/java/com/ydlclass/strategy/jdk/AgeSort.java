package com.ydlclass.strategy.jdk;

import java.util.Comparator;

/**
 * @author
 * @createTime 2023-06-01
 */
public class AgeSort implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
