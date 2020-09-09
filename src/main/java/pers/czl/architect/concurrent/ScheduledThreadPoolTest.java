package pers.czl.architect.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledThreadPoolTest test = new ScheduledThreadPoolTest();
        //test.test1();
        //test.test2();
        //test.test3();
        test.test4();
    }

    private void test1() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("3秒后执行该任务");
        }, 3, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.shutdown();
    }

    private void test2() throws ExecutionException, InterruptedException {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        ScheduledFuture future = scheduledThreadPoolExecutor.schedule(() -> {
            System.out.println("3秒后执行该任务，可以有返回值");
            return 1;
        }, 3, TimeUnit.SECONDS);
        System.out.println("返回值是：" + future.get());
        scheduledThreadPoolExecutor.shutdown();
    }

    private void test3() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        long start = System.currentTimeMillis();
        scheduledThreadPoolExecutor.scheduleAtFixedRate(() -> {
            System.out.println("3秒后执行该任务，每次耗时5秒，如果上一个任务没执行完，要等上一个执行完成，耗时：" + (System.currentTimeMillis() - start));
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, 3, 1, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.shutdown();
    }

    private void test4() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        long start = System.currentTimeMillis();
        scheduledThreadPoolExecutor.scheduleWithFixedDelay(() -> {
            System.out.println("3秒后执行该任务，每次耗时5秒。每隔1秒周期性执行一次任务。耗时：" + (System.currentTimeMillis() - start));
        }, 3, 1, TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.shutdown();
    }
}
