package com.ydlclass.adapter.object;


/**
 * @author 
 * @createTime 2023-05-24
 */
public class ObjectAdapterTwo implements Target {

    private AdapteeTwo adaptee;

    public ObjectAdapterTwo(AdapteeTwo adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.specificRequest();
    }
}
