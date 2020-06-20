package com.czl.architect.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * @Title: 自定义类加载器
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-06-19 14:38
 * @Version:1.0
 **/
public class TestCustomClassLoader {

    public static void main(String[] args) throws Exception {
        final String classPath = "D:/classPath";
        CustomClassLoader customClassLoader = new CustomClassLoader(classPath);
        Class clazz = customClassLoader.loadClass("com.czl.architect.jvm.HelloJvm");
        Method sayHello = clazz.getDeclaredMethod("sayHello");
        Object obj = clazz.newInstance();
        sayHello.invoke(obj);
        System.out.println(clazz.getClassLoader());
    }

    static class CustomClassLoader extends ClassLoader {
        private final String classPath;

        CustomClassLoader(String classPath) {
            this.classPath = classPath;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] bytes = this.loadByte(name);
                return this.defineClass(name, bytes, 0, bytes.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException(name);
            }
        }


        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] bytes = new byte[len];
            fis.read(bytes);
            fis.close();
            return bytes;
        }
    }
}