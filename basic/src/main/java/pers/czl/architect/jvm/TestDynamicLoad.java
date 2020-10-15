package pers.czl.architect.jvm;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-06-18 11:27
 * @Version:1.0
 **/
public class TestDynamicLoad {

    static {
        System.out.println("========== 加载TestDynamicLoad ==========");
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("========== A加载完毕 ==========");
        B b = null; //B不会被加载，除非执行new B();
    }
}

class A {
    static {
        System.out.println("========== 加载A ==========");
    }

    public A() {
        System.out.println("========== 初始化A ==========");
    }
}

class B {
    static {
        System.out.println("========== 加载B ==========");
    }

    public B() {
        System.out.println("========== 初始化B ==========");
    }
}