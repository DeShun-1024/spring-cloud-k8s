package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitAndSleepDemo {


    private int stock = 0;

    public synchronized void product() throws InterruptedException {
        while (stock != 0) {
            // 等待
            this.wait();
        }
        stock++;
        log.info("生产者 生产" + Thread.currentThread().getName() + "===> +1 " + stock);
        this.notifyAll();
    }

    public synchronized void consumer() throws InterruptedException {
        while (stock == 0) {
            //等待
            this.wait();
        }
        stock--;
        log.info("消费者 消费" + Thread.currentThread().getName() + "===> -1 " + stock);
        this.notifyAll();
    }


    public static void main(String[] args) {
        WaitAndSleepDemo pc_demo = new WaitAndSleepDemo();
        for (int j = 0; j < 5; j++) {
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        pc_demo.product();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int j = 0; j < 5; j++) {
            new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    try {
                        pc_demo.consumer();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
