package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {

        // 底层是调用unsafe的park，本地方法
        final Thread thread = new Thread(() -> {
            LockSupport.park();
            System.out.println("11");
        }, "A");
        thread.start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(() -> {
            LockSupport.unpark(thread);
        }, "A9").start();
    }
}
