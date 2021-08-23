package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列
 * <p>
 * 进去一个元素，必须等这个元素取出后，才能放下个元素
 *
 * @author hudeshun
 * @since 2021/4/2 18:15
 */
public class SynchronousQueueDemo {

    public static void putDemo() throws InterruptedException {
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        queue.put("1");

    }


    public static void putAndTake() throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();

        for (int i = 1; i <= 1; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "put 1");

                    queue.put("1");
                    System.out.println("ok");


//                    System.out.println(Thread.currentThread().getName() + "put 2");
//                    queue.put("2");
//
//                    System.out.println(Thread.currentThread().getName() + "put 3");
//                    queue.put("3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        for (int i = 1; i <= 1; i++) {
            int finalI = i;
            new Thread(() -> {
                try {

                    TimeUnit.SECONDS.sleep(finalI);

                    queue.take();
                    System.out.println(Thread.currentThread().getName() + "take 1");

//
//                    System.out.println(Thread.currentThread().getName() + "take 2");
//                    queue.take();
//
//                    System.out.println(Thread.currentThread().getName() + "take 3");
//                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        putDemo();
        putAndTake();
    }
}
