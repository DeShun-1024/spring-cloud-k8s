package com.cloud.k8s.springcloudk8s.juc;

public class ThreadDemo {

    private static native void registerNatives();
    static {
        registerNatives();
    }


    private native void start0();


    public synchronized void start(){
        start0();
    }



    public static void main(String[] args) {
        ThreadDemo  threadDemo = new ThreadDemo();
        threadDemo.start();

    }
}
