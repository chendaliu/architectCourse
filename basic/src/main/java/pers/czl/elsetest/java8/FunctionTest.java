package pers.czl.elsetest.java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Title: Consumer，Supplier，Function，Predicate
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-09-09 15:12
 * @Version:1.0
 **/
public class FunctionTest {

    /**
     * Consumer  有参无返回
     * Supplier  无参有返回
     * Function  有参有返回
     * Predicate 有参返回bool
     **/
    public static void main(String[] args) {

        // test Consumer 消费
        Consumer<String> con1 = System.out::println;
        con1.accept("consumer输出的");

        // test Supplier 提供
        Supplier<String> supplier = () -> {
            return "supplier返回的";
        };
        System.out.println(supplier.get());

        // test Function String to Integer 类型转换
        Function<String, Integer> function = Integer::parseInt;
        String oldVal = "100";
        int val = function.apply(oldVal);
        System.out.println("val:" + val);

        // test Predicate 判断
        Predicate<Integer> predicate1 = o -> {
            return o > 100;
        };
        Predicate<Integer> predicate2 = o -> {
            return o < 200;
        };
        boolean predicateResult = predicate1.and(predicate2).test(150);
        boolean predicateResult1 = predicate1.and(predicate2).test(300);
        System.out.println("predicateResult: " + predicateResult);
        System.out.println("predicateResult1: " + predicateResult1);

    }

    private static String newString(Supplier<String> supplier) {
        return supplier.get();
    }
}