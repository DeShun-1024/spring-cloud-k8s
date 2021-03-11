package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 同步减法计数器
 */
public class count_down_latch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    System.out.println("执行");
                    TimeUnit.SECONDS.sleep(5);
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("任务全部完成");

    }
}
