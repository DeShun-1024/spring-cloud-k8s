package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.locks.ReentrantLock;

public class MyReentrantLock extends ReentrantLock {

    public static void main(String[] args) throws InterruptedException {
        MyReentrantLock lock = new MyReentrantLock();
        lock.lock();
    }
}
