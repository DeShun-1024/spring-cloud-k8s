package com.cloud.k8s.springcloudk8s.juc;

/**
 * 同步代码块锁住的对象，
 * 1、对象中的内部对象
 * 2、this相当于对象本身
 */
public class SynchronousDemo {


    public static void main(String[] args) {
        final Demo demo = new Demo();
        final Demo demo1 = new Demo();


        new Thread(() -> {
            demo.show1();
        }).start();

        new Thread(() -> {
            demo.show2();
        }).start();


    }

}


class Demo {

    private String str = "1";

    private static String staticStr = "ss";

    /**
     * 锁住的是this对象中的str对象
     */
    public void show1() {
        synchronized (str) {
            System.out.println(Thread.currentThread().getName() + "show1");
            System.out.println(Thread.currentThread().getName() + "show1执行开发");
            System.out.println(Thread.currentThread().getName() + "show1执行结束");
            while (true) {

            }
        }
    }

    /**
     * 锁住的是this对象中的staticStr对象，
     */
    public void show2() {
        synchronized (staticStr) {
            System.out.println(Thread.currentThread().getName() + "show2");
            System.out.println(Thread.currentThread().getName() + "show2执行开发");
            System.out.println(Thread.currentThread().getName() + "show2执行结束");
        }
    }
}