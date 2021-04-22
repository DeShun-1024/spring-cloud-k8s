package com.cloud.k8s.springcloudk8s.basic;

public class FinalDemo {

    public static void main(String[] args) {
        Integer first = 10;
        final int a = first;
        first = 20;
        System.out.println(a);
    }
}
