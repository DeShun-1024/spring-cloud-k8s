package com.cloud.k8s.springcloudk8s.juc;

public class WaitAndNotifyDemo {

    public synchronized void test() {
        WaitAndNotifyDemo demo = new WaitAndNotifyDemo();

        // 为什么会报错 demo是没有锁的
        demo.notify();

        // this是有锁的 因为这个方法的调用者必须要获得锁
        this.notify();
    }


    public static void main(String[] args) {
        WaitAndNotifyDemo demo = new WaitAndNotifyDemo();
        demo.test();
    }

}
