package com.ydlclass.creational;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author
 * @createTime 2023-05-08
 */
public enum GlobalCounter {
    INSTANCE,

    INSTANCE1;

    private AtomicLong atomicLong = new AtomicLong(0);

    public Long getNumber(){
        return atomicLong.getAndIncrement();
    }

}
