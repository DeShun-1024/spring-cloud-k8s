package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 同步工具类
 *
 *1、countdown 是调用线程阻塞等待，cyclicbarrier 是执行线程相互等待，而且调用线程是不阻塞的。
 *
 */
@Slf4j
public class CountDownLatchDemo {


    public static void cyclicBarrierDemo() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, new Runnable() {
            @Override
            public void run() {
                log.info("龙珠已收集完成！召唤神龙！");
            }
        });
        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                log.info(Thread.currentThread().getName() + ":收集龙珠!");
                try {
                    TimeUnit.SECONDS.sleep(3L);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        System.out.println("aa");
    }

    /**
     * 同步减法计数器，等待所有任务执行完，
     */
    public static void countDownLatch() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    log.info(Thread.currentThread().getName() + ":执行!");
                    TimeUnit.SECONDS.sleep(5);
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        log.info(Thread.currentThread().getName() + ": 执行await之前");
        countDownLatch.await();
        log.info(Thread.currentThread().getName() + ": 任务完成");
    }

    public static void main(String[] args) throws InterruptedException {
//        countDownLatch();
        cyclicBarrierDemo();
    }

}
