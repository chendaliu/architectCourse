package pers.czl.architect.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * oom、飙高cpu、死锁一起测试
 * 2020年7月5日
 */
public class OOMHighCpuDeadLockTest {

    /**
     * -Xms5M -Xmx5M -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/demo/jvmOomDump.dump
     * 加上以上参数在发生内存溢出时会导出dump
     */
    public static void main(String[] args) {
        OOMHighCpuDeadLockTest test = new OOMHighCpuDeadLockTest();
        //飙高cpu
        test.highCpu();
        //内存溢出
        test.heapOom();
        //死锁
        test.deadLock();
    }

    public void deadLock() {
        Object object1 = new Object();
        Object object2 = new Object();
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

    public void highCpu() {
        new Thread(() -> {
            for (; ; ) {

            }
        }).start();
    }

    public void heapOom() {
        new Thread(() -> {
            Student student;
            List<Student> list = new ArrayList<>();
            int i = 0;
            for (; ; ) {
                System.out.println(i++);
                list.add(new Student());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    class Student {
        byte[] bytes = new byte[1024];
    }
}
