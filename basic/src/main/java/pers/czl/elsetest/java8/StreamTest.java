package pers.czl.elsetest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-09 15:51
 * @Version:1.0
 **/
public class StreamTest {

    public static void main(String[] args) {
        StreamTest streamTest = new StreamTest();
        //streamTest.testCollectors();
        streamTest.testStreamIterator();
    }

    private void testCollectors() {
        Student s1 = new Student("aa", 10, 1);
        Student s2 = new Student("bb", 20, 2);
        Student s3 = new Student("cc", 10, 3);
        List<Student> list = Arrays.asList(s1, s2, s3);

        Map<Integer, String> map = list.stream().collect(Collectors.toMap(Student::getId, Student::getName));

    }

    private void testStreamIterator() {
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
    }

    private class Student {
        private int id;
        private String name;
        private int age;

        public Student(String name, int age, int id) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

}

