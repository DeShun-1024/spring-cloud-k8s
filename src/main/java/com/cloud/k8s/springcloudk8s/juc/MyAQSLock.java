package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;


@Slf4j
public class MyAQSLock extends AbstractQueuedSynchronizer {

    /**
     * 不可重入锁，实现线程加锁
     * 比较当前线程与工作线程是否同一个线程；
     */
    @Override
    protected boolean tryAcquire(int arg) {
        final Thread exclusiveOwnerThread = getExclusiveOwnerThread();

        final Thread thread = Thread.currentThread();

        setExclusiveOwnerThread(thread);
        return compareAndSetState(0, arg);
    }

    /**
     * 重写该方法，实现锁的释放
     */
    @Override
    protected boolean tryRelease(int arg) {
        int c = getState() - arg;
        boolean free = false;
        if (c == 0) {
            free = true;
            setExclusiveOwnerThread(null);
        }
        setState(c);
        return free;
    }

    public void lock() {
        acquire(1);
    }

    public void unlock() {
        release(1);
    }

    private static class RunnableDemo implements Runnable {

        private MyAQSLock myAQSLock;

        public RunnableDemo(MyAQSLock myAQSLock) {
            this.myAQSLock = myAQSLock;
        }

        @Override
        public void run() {
            myAQSLock.lock();
            try {
                log.info("线程名称:{}", Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                myAQSLock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        MyAQSLock myAQSLock = new MyAQSLock();

        for (int i = 0; i < 10; i++) {
            new Thread(new RunnableDemo(myAQSLock)).start();
        }

    }
}
