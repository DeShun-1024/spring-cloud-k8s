package com.cloud.k8s.springcloudk8s.basic;

public class ThreadLocalDemo {

    public static void show(){
        Thread thread = Thread.currentThread();

        System.out.println(thread);
    }

    public static void threadLocalDemo(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("2345");
        threadLocal.set("sddfff");

        System.out.println(threadLocal.get());
    }


    public static void main(String[] args) {
//        show();
        threadLocalDemo();
    }
}
