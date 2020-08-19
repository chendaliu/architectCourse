package pers.czl.architect.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-13 15:31
 * @Version:1.0
 **/
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(false);
        for (int i = 0; i < 2000; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                reentrantLock.lock();
                try {
                    //Thread.sleep(100 * 1000);
                    System.out.println(Thread.currentThread() + "获得锁");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                    System.out.println(Thread.currentThread() + "释放锁");
                }

            });
            thread.start();
        }
    }


}