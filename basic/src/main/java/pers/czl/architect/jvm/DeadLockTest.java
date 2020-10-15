package pers.czl.architect.jvm;

import java.util.concurrent.TimeUnit;

/**
 * @Title: 死锁测试
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-07-04 10:32
 * @Version:1.0
 **/
public class DeadLockTest {
    private static Object object1 = new Object();
    private static Object object2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (object1) {
                System.out.println("thread1 get object1");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                    System.out.println("thread1 get object2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (object2) {
                System.out.println("thread2 get object2");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("thread2 get object1");
                }
            }
        }).start();

    }
}
