package com.czl.architect.jvm;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

/**
 * @Title: 打破双亲委派机制
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-06-19 16:04
 * @Version:1.0
 **/
public class TestNoDetegate {

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/classPath");
        Class clazz = myClassLoader.loadClass("com.czl.architect.jvm.HelloJvm");
        Object obj = clazz.newInstance();
        Method method = clazz.getDeclaredMethod("sayHello");
        method.invoke(obj);
        System.out.println(clazz.getClassLoader());
    }

    static class MyClassLoader extends ClassLoader {

        private final ProtectionDomain defaultDomain =
                new ProtectionDomain(new CodeSource(null, (Certificate[]) null),
                        null, this, null);

        private final String classPath;

        MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        protected Class<?> loadClass(String name, boolean resolve)
                throws ClassNotFoundException
        {
            synchronized (getClassLoadingLock(name)) {
                // First, check if the class has already been loaded
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    if (!name.startsWith("com.czl.architect")) {
                        c = ClassLoader.getSystemClassLoader().loadClass(name);
                    } else {
                        c = findClass(name);
                    }

                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] bytes = this.loadByte(name);
                return this.defineClass(name, bytes, 0, bytes.length, defaultDomain);
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