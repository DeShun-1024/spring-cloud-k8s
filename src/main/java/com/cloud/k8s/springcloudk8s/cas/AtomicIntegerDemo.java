package com.cloud.k8s.springcloudk8s.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(10);

        System.out.println(integer.compareAndSet(10,23));
        System.out.println(integer.get());
    }
}
