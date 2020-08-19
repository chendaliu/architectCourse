package pers.czl.elsetest.java8;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-14 17:50
 * @Version:1.0
 **/
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);

}