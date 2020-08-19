package pers.czl.architect.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-14 15:46
 * @Version:1.0
 **/
public class LockSupportTest {
    public static void main(String[] args) throws InterruptedException {
        String a = new String("A");
        Thread t = new Thread(() -> {
            System.out.println("睡觉");
            LockSupport.park(a);
            System.out.println("起床");
            System.out.println("是否中断：" + Thread.currentThread().isInterrupted());
        });

        t.setName("A-Name");
        t.start();
        System.out.println(1);
        t.interrupt();
        System.out.println("突然肚子很疼");
    }
}