package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@Slf4j
public class SemaphoreDemo {


    /**
     * 限流的用的比较多
     */
    public static void semaphoreDemo() {
        Semaphore semaphore = new Semaphore(8);
        for (int i = 1; i <= 500; i++) {
            new Thread(() -> {
                try {
                    // 需要等所有信号量都可用
                    semaphore.acquire();
                    log.info("{}:抢到车位", Thread.currentThread().getName());

                    TimeUnit.SECONDS.sleep(2);
                    log.info("{}:离开车位", Thread.currentThread().getName());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        semaphoreDemo();
    }


}
