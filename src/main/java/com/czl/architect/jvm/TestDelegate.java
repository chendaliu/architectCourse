package com.czl.architect.jvm;

/**
 * @Title: 测试双亲委派机制
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-06-19 13:02
 * @Version:1.0
 **/
public class TestDelegate {
    public static void main(String[] args) {
        try {
            Class clazz = ClassLoader.getSystemClassLoader().loadClass(com.czl.architect.jvm.TestJdkClassLoader.class.getName());
            System.out.println(clazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}