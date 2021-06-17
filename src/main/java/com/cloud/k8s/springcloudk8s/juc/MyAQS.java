package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class MyAQS extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {

        if (compareAndSetState(0,1)){
            setExclusiveOwnerThread(Thread.currentThread());

        }
        return super.tryAcquire(arg);
    }
}
