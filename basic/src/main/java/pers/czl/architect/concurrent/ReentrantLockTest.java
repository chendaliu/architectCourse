package pers.czl.architect.concurrent;

import pers.czl.architect.netty.bio.SocketClient;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);
        for (int i = 0; i < 10; i ++) {
            new Thread(() -> {
                lock.lock();
                System.out.println("线程获取到锁" + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
}
