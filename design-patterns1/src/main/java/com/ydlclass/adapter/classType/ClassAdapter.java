package com.ydlclass.adapter.classType;

/**
 * 使用继承来实现适配的能力
 * @author 
 * @createTime 2023-05-24
 */
public class ClassAdapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.specificRequest();
    }
}
