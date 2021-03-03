package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {


    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.State.BLOCKED);


        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());

        Semaphore semaphore = new Semaphore(9);
        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(() -> {
                try {
                    if (semaphore.tryAcquire(1, TimeUnit.SECONDS)) {
                        System.out.println("获得车位" + Thread.currentThread().getName());
                    }
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("开出车位" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }



        poolExecutor.shutdown();

    }


}
