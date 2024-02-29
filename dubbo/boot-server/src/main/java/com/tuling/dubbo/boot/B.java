package com.tuling.dubbo.boot;

/**
 * @author: daliu
 * @since: 2023-07-26 21:47
 **/
public class B extends A{
    public B() {
        System.out.println("B");
    }

    public static void main(String[] args) {
        new B();
    }
}
