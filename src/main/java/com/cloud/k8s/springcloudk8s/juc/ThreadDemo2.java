package com.cloud.k8s.springcloudk8s.juc;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

@Slf4j
@Getter
public class ThreadDemo2 implements Runnable {


    private final Thread thread;

    public ThreadDemo2() {
        this.thread = Executors.defaultThreadFactory().newThread(this);
    }


    @Override
    public void run() {

        System.out.println("thread-demo-2");
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadDemo2 threadDemo2 = new ThreadDemo2();

        final Thread thread = threadDemo2.getThread();
        thread.start();
    }
}
