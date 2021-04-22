package com.cloud.k8s.springcloudk8s.juc;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class WaitDemo {


    public synchronized void testWait() throws InterruptedException {
        System.out.println("执行sleep开始:" + LocalDateTime.now());
        TimeUnit.SECONDS.sleep(5);
        System.out.println("执行sleep完成:" + LocalDateTime.now());

        System.out.println("执行wait开始:" + LocalDateTime.now());
        this.wait(5000L);
        System.out.println("执行wait完成:" + LocalDateTime.now());
    }

    public synchronized void show() {
        System.out.println("show");
    }

    public synchronized void testNotify() throws InterruptedException {
        this.notify();
    }

    public static void test(){
        final WaitDemo demo = new WaitDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.testWait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public static void main(String[] args) throws Exception {

        WaitDemo waitDemo = new WaitDemo();
        synchronized (waitDemo){
            waitDemo.wait();
        }


        TimeUnit.SECONDS.sleep(3L);
    }
}
