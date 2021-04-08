package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Slf4j
public class ConditionDemo {

    private Integer stock = 0;

    private Lock lock = new ReentrantLock();

    final Condition conditionA = lock.newCondition();
    final Condition conditionB = lock.newCondition();
    final Condition conditionC = lock.newCondition();
    final Condition conditionD = lock.newCondition();


    public void productA() {
        lock.lock();
        try {
            while (stock != 0) {
                conditionA.await();
            }
            stock = 1;
            log.info("{} 生产。数量：{}", Thread.currentThread().getName(), stock);
            conditionB.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumerB() {
        lock.lock();
        try {
            while (stock != 1) {
                conditionB.await();
            }
            stock = 2;
            log.info("{} 消费。数量：{}", Thread.currentThread().getName(), stock);
            conditionC.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void productC() {
        lock.lock();
        try {
            while (stock != 2) {
                conditionC.await();
            }
            stock = 3;
            log.info("{} 生产。数量：{}", Thread.currentThread().getName(), stock);
            conditionD.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumerD() {
        lock.lock();
        try {
            while (stock != 3) {
                conditionD.await();
            }
            stock = 0;
            log.info("{} 消费。数量：{}", Thread.currentThread().getName(), stock);
            conditionA.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo lock_demo = new ConditionDemo();

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                lock_demo.productA();
            }, "A").start();
            new Thread(() -> {
                lock_demo.consumerB();
            }, "B").start();
            new Thread(() -> {
                lock_demo.productC();
            }, "C").start();
            new Thread(() -> {
                lock_demo.consumerD();
            }, "D").start();
        }


    }
}
