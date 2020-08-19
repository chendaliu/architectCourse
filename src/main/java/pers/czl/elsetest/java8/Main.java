package pers.czl.elsetest.java8;

import java.util.Arrays;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-14 17:21
 * @Version:1.0
 **/
public class Main {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        strings.stream().filter(string -> !string.isEmpty()).forEach(System.out::println);

        System.out.println("==============");
        strings.stream().map(string -> !string.isEmpty()).forEach(System.out::println);

    }

}