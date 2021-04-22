package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * rejectedExecution 这个接口，threadPoolExcutor 实现了4种拒绝策略，具体的拒绝策略是在该接口的rejectedExecution 方法
 * 1、直接抛出异常
 * 2、直接丢弃，不进行任务处理。
 * 3、交由调用线程执行，
 * 4、尝试与最先执行的竞争，尝试执行，否则抛弃，
 * @author hudeshun
 * @since 2021/4/5 22:28
 */
public class ThreadPoolDemo {

    public static void discardOldestPolicy(){
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                3,
                5L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy() //丢弃最老的未处理的，尝试执行，否则抛弃，
        );


        try {
            for (int i = 1; i <= 197; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }




    public static void callRunPolicy() {
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                3,
                5L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy() //调用线程执行任务，本例中采用的是main线程
        );

        try {
            for (int i = 1; i <= 197; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }

    public static void discardPolicy() {
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                3,
                5L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy() // 直接丢弃、不抛任何异常
        );

        try {
            for (int i = 1; i <= 17; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }

    }


    public static void poolDemo() {
        // 线程池的最大承载：max+workQueue
        final ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2, // 核心线程数
                5, // 最大线程数，只有工作队列满了，才会触发
                5L, // 超出核心线程的空闲线程，存活的最大时间
                TimeUnit.SECONDS,  // 时间单位
                new ArrayBlockingQueue<>(2), // 工作队列，超出核心线程数后，任务放在工作队列
                Executors.defaultThreadFactory(), // 线程工厂
                new ThreadPoolExecutor.AbortPolicy()  // 拒绝策略：大于最大承载就抛出异常
        );

        try {
            for (int i = 1; i <= 8; i++) {
                poolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }
    }

    public static void main(String[] args) {
//        poolDemo();
//        discardPolicy();
//        callRunPolicy();
        discardOldestPolicy();
    }

}
