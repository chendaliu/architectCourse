package com.ydlclass.templateMethod.callback;

/**
 * @author
 * @createTime 2023-06-01
 */
public class AClass {

    public void process(ICallBack callback,ICallBack callback2) {
        // 1、可以复用的代码
        System.out.println("第一步");

        // 2、回调
        callback.methodToCallback();

        callback2.methodToCallback();

        // 3、可以复用的代码
    }

}
