package pers.czl.architect.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-21 15:19
 * @Version:1.0
 **/
public class SemaphoreTest {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(4);

        /*for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 正在获取");

                    semaphore.acquire();
                    long start = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + " 开始执行");
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + " 执行完成，耗时：" + (System.currentTimeMillis() - start));
                    semaphore.release();

                    System.out.println(Thread.currentThread().getName() + " 释放完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }*/

        int num = 10;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < num; i++) {
            new Thread(() -> {
                try {

                    if (!semaphore.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
                        lowService();
                        return;
                    }
                    count.incrementAndGet();
                    long start = System.currentTimeMillis();
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + " 执行完成，耗时：" + (System.currentTimeMillis() - start));
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }

        countDownLatch.await();
        System.out.println(count + "个线程成功");
    }

    private static void lowService() {
        System.out.println(Thread.currentThread() + " 服务降级");
    }
}