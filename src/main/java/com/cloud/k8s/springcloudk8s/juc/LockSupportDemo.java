package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@Slf4j
public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {

        // 底层是调用unsafe的park，本地方法
        final Thread thread = new Thread(() -> {
            LockSupport.park();
            log.info("LockSupport.park()");
        }, "A");
        thread.start();

        TimeUnit.SECONDS.sleep(1);
//        new Thread(() -> {
//            LockSupport.unpark(thread);
//            log.info("LockSupport.unpark()");
//        }, "A9").start();

        // 唤醒后，才会执行
        LockSupport.unpark(thread);
    }
}
