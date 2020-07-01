package com.czl.architect.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-07-01 10:32
 * @Version:1.0
 **/
public class OOMTest {

    public static void main(String[] args) throws InterruptedException {
        OOMTest oomTest = new OOMTest();
        oomTest.heapOom();
    }

    /**
     * -Xms5M -Xmx5M
     * @throws InterruptedException
     */
    public void heapOom() throws InterruptedException {
        byte[] bytes = new byte[256];
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        for(;;) {
            //System.out.println(i++);//47427
            list.add(bytes);
            Thread.sleep(1000);
        }
    }
}