package com.ydlclass.templateMethod.callback;

/**
 * @author
 * @createTime 2023-06-01
 */
public class Main {

    public static void main(String[] args) {
        AClass aClass = new AClass();
        aClass.process(
                ()-> System.out.println("第一个回调"),
                ()-> System.out.println("第二个回调")
        );
    }

}
