package com.cloud.k8s.springcloudk8s.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class LockTest {



    public synchronized void test(){

    }

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        LockTest test = new LockTest();
        test.wait();

        final List<Object> objects = Collections.synchronizedList(new ArrayList<>());

        final CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();

        final CountDownLatch countDownLatch = new CountDownLatch(6);

        final Semaphore semaphore = new Semaphore(1);

        final BlockingQueue<String> objects2 = new ArrayBlockingQueue<String>(1);


    }
}
