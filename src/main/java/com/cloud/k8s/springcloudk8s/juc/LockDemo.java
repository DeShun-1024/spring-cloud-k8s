package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {


    public void test() {
        Lock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        lock.lock();

        try {


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }


    public static void main(String[] args) {


    }
}
