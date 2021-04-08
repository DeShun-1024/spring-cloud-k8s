package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadDemo {


    /**
     * 1、一个线程持有锁,另外一个线程获取这个锁，如果获取不到就处于block
     * 2、或者在是调用wait方法后，再次获取锁
     */
    public static void block() throws InterruptedException {
        ThreadDemo demo = new ThreadDemo();

        final Thread thread = new Thread(() -> {
            try {
                synchronized (demo) {
                    TimeUnit.SECONDS.sleep(10000L);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1");
        thread.start();

        final Thread thread1 = new Thread(() -> {
            synchronized (demo) {
                try {
                    demo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "2");
        thread1.start();

        // 确定两个线程都启动
        TimeUnit.SECONDS.sleep(2L);
        log.info("线程1状态：{}", thread.getState());
        log.info("线程2状态：{}", thread1.getState());
    }


    public static void strart() {
        final Thread thread = new Thread(() -> {
        });

        thread.start();

        log.info("线程状态：{}", thread.getState());
    }


    public static void newState() {
        final Thread thread = new Thread(() -> {
            System.out.println("new");
        });

        log.info("线程状态：{}", thread.getState());
    }


    public static void main(String[] args) throws InterruptedException {
//        newState();
//        strart();
//        block();
    }
}
