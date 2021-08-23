package com.cloud.k8s.springcloudk8s.juc;

import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo implements Runnable {


    private final ThreadLocal<String> threadLocal;


    public ThreadLocalDemo(ThreadLocal<String> threadLocal) {
        this.threadLocal = threadLocal;
    }

    @SneakyThrows
    @Override
    public void run() {
        threadLocal.set("gggg" + Thread.currentThread().getName());
        TimeUnit.MILLISECONDS.sleep(5L);

        final String s = threadLocal.get();
        System.out.println("线程名称:" + Thread.currentThread().getName() + ",threadLocal:" + s);
    }


    static class ThreadLocalDemo2 implements Runnable {
        private final Map<String, String> map;

        ThreadLocalDemo2(Map<String, String> map) {
            this.map = map;
        }

        @SneakyThrows
        @Override
        public void run() {
            map.put("key", "gggg" + Thread.currentThread().getName());
            TimeUnit.MILLISECONDS.sleep(5L);
            final String s = map.get("key");
            System.out.println("线程名称:" + Thread.currentThread().getName() + ",threadLocal:" + s);
        }
    }

    /**
     * ThreadLocal 中的ThreadLocalMap ，底层是数组，但是为什么以map命名？ hashMap的底层也是数组？
     */
    public static void main(String[] args) throws InterruptedException {

        // thread 线程
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        for (int i = 0; i < 60; i++) {
            new Thread(new ThreadLocalDemo(threadLocal)).start();
        }

        TimeUnit.SECONDS.sleep(2);

        System.out.println("***************");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 50; i++) {
            new Thread(new ThreadLocalDemo2(map)).start();
        }

    }


}
