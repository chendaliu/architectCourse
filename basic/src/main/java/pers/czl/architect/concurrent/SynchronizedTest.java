package pers.czl.architect.concurrent;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-08-10 14:13
 * @Version:1.0
 **/
public class SynchronizedTest {
    public static void main(String[] args) throws InterruptedException {
        HashMap map = new HashMap();
        map.put(1, 1);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                //while在try中，通过异常中断就可以退出run循环
                try {
                    //当前线程处于阻塞状态，异常必须捕捉处理，无法往外抛出
                    TimeUnit.SECONDS.sleep(20);
                } catch (InterruptedException e) {
                    System.out.println("Interruted When Sleep");
                    boolean interrupt = this.isInterrupted();
                    //中断状态被复位
                    System.out.println("interrupt:" + interrupt);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        //中断处于阻塞状态的线程
        t1.interrupt();

        /**
         * 输出结果:
         Interruted When Sleep
         interrupt:false
         */
    }

}