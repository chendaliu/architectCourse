package pers.czl.architect.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
    public static void main(String[] args) {
        SynchronizedTest sync = new SynchronizedTest();
        sync.testSync();
    }

    public void testSync() {
        synchronized (this) {
            System.out.println(111111111);
        }
        synchronized (SynchronizedTest.class) {
            System.out.println(2);
        }
        ReentrantLock reentrantLock = new ReentrantLock(true);
        reentrantLock.lock();
    }
}
