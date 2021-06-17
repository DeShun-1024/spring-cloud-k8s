package com.cloud.k8s.springcloudk8s.jvm;


import java.util.Map;
import java.util.concurrent.TimeUnit;

public class StackMessage extends ClassLoader{


    public static void test() throws InterruptedException {
        for (; ; ) {
            TimeUnit.SECONDS.sleep(3L);
        }
    }


    public static void main(String[] args) throws Exception {

        test();

        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        final Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        for (Map.Entry<Thread, StackTraceElement[]> threadEntry : allStackTraces.entrySet()) {
            System.out.println(threadEntry.getKey());
            for (StackTraceElement stackTraceElement : threadEntry.getValue()) {
                System.out.println(stackTraceElement);
            }

            System.out.println("----");
        }
    }
}
