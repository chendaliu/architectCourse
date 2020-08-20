package pers.czl.architect.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-19 10:40
 * @Version:1.0
 **/
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long startMain = System.currentTimeMillis();
        new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(random.nextInt(6 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("线程1耗时：" + (System.currentTimeMillis() - start));
        }).start();

        new Thread(() -> {
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(random.nextInt(6 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("线程2耗时：" + (System.currentTimeMillis() - start));
        }).start();

        System.out.println("主线程等待");
        countDownLatch.await();
        System.out.println("主线程耗时：" + (System.currentTimeMillis() - startMain));
        System.out.println("主线程执行完成");
    }
}