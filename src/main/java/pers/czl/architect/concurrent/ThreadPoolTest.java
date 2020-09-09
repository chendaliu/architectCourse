package pers.czl.architect.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /*Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();*/

        long start = System.currentTimeMillis();
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(4, 4, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        Future<?> future = threadPoolExecutor.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        });

        //2秒获取不到就超时
        //System.out.println("返回值" + future.get(2, TimeUnit.SECONDS) + "耗时：" + (System.currentTimeMillis() - start));

        //这里会阻塞住，直到线程返回值
        System.out.println("返回值" + future.get() + "耗时：" + (System.currentTimeMillis() - start));

        threadPoolExecutor.shutdown();
    }
}
