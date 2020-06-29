package com.czl.architect.jvm;

import com.sun.nio.zipfs.ZipPath;

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
            Class clazz = ClassLoader.getSystemClassLoader().loadClass(com.architect.jvm.TestDynamicLoad.class.getName());
            System.out.println(clazz.getClassLoader());

            Class zipClazz = ClassLoader.getSystemClassLoader().loadClass(ZipPath.class.getName());
            System.out.println(zipClazz.getClassLoader());

            Class strClazz = ClassLoader.getSystemClassLoader().loadClass(String.class.getName());
            System.out.println(strClazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}