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
            //这里不能用String类测试，因为在启动过程中已经加载过String。这里用Applet测试，Applet也是一个位于jre/lib文件夹下面的类
            Class clazz = ClassLoader.getSystemClassLoader().loadClass(java.applet.Applet.class.getName());
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}