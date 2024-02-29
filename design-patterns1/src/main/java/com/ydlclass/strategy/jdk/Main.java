package com.ydlclass.strategy.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 * @createTime 2023-06-01
 */
public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("tom",12,89);
        Student student2 = new Student("jerry",15,74);
        Student student3 = new Student("lily",25,68);
        Student student4 = new Student("alin",19,10);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        // 针对以上的学生进行年龄的排序
        students.sort(new AgeSort());
        System.out.println(students);

        students.sort( (s1,s2) -> (int)(s1.getScore() - s2.getScore()));
        System.out.println(students);

    }

}
