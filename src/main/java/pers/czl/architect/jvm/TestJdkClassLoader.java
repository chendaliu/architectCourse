package pers.czl.architect.jvm;

import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-06-18 19:18
 * @Version:1.0
 **/
public class TestJdkClassLoader {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());//String位于jre/lib文件夹，由引导类加载器加载
        System.out.println(com.sun.nio.zipfs.ZipPath.class.getClassLoader());//位于jre/lib/ext文件夹的类，由扩展类加载器加载
        System.out.println(TestJdkClassLoader.class.getClassLoader());

        System.out.println("===========================================");

        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();//系统类加载器默认是应用程序类加载器AppClassLoader
        ClassLoader extClassLoader = appClassLoader.getParent();//AppClassLoader父加载器是扩展类加载器extClassLoader
        ClassLoader bootstrapLoader = extClassLoader.getParent();//extClassLoader父加载器是引导类加载器bootstrapLoader
        System.out.println("appClassLoader:" + appClassLoader);
        System.out.println("extClassLoader:" + extClassLoader);
        System.out.println("bootstrapLoader:" + bootstrapLoader);

        System.out.println("===========================================");

        System.out.println("bootstrapLoader加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i]);
        }
        System.out.println("===========================================");

        System.out.println("extClassloader加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println("===========================================");

        System.out.println("appClassLoader加载以下文件：");
        Arrays.stream(System.getProperty("java.class.path").split(";")).forEach(System.out::println);
    }
}