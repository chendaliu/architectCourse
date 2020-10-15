package pers.czl.architect.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-19 10:40
 * @Version:1.0
 **/
public class CountDownLatchTest {

    /**
     * 主线程等待子线程
     *
     * @param args
     */
    /*public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        long startMain = System.currentTimeMillis();

        Task1 task1 = new Task1(countDownLatch);
        Task2 task2 = new Task2(countDownLatch);
        new Thread(task1).start();
        new Thread(task2).start();

        System.out.println("主线程等待");
        countDownLatch.await();
        System.out.println("主线程耗时：" + (System.currentTimeMillis() - startMain));
        System.out.println("主线程执行完成");
    }*/
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        long startMain = System.currentTimeMillis();
        Task3 task1 = new Task3(countDownLatch);
        Task4 task2 = new Task4(countDownLatch);
        new Thread(task1).start();
        new Thread(task2).start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println("主线程执行完成");
        System.out.println("主线程耗时：" + (System.currentTimeMillis() - startMain));
    }

    private static class Task1 implements Runnable {
        CountDownLatch countDownLatch;

        public Task1(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Random random = new Random();
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(random.nextInt(6 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("线程1耗时：" + (System.currentTimeMillis() - start));
        }
    }

    private static class Task2 implements Runnable {
        CountDownLatch countDownLatch;

        public Task2(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            Random random = new Random();
            long start = System.currentTimeMillis();
            try {
                Thread.sleep(random.nextInt(6 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                countDownLatch.countDown();
            }
            System.out.println("线程2耗时：" + (System.currentTimeMillis() - start));
        }
    }


    private static class Task3 implements Runnable {
        CountDownLatch countDownLatch;

        public Task3(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Random random = new Random();
            long start = System.currentTimeMillis();
            System.out.println("线程1在等主线程");
            try {
                countDownLatch.await();
                System.out.println("线程1开始执行");
                TimeUnit.SECONDS.sleep(random.nextInt(6));
                System.out.println("线程1执行结束，耗时：" + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Task4 implements Runnable {
        CountDownLatch countDownLatch;

        public Task4(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            Random random = new Random();
            long start = System.currentTimeMillis();
            System.out.println("线程2在等主线程");
            try {
                countDownLatch.await();
                System.out.println("线程2开始执行");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println("线程2执行结束，耗时：" + (System.currentTimeMillis() - start));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}