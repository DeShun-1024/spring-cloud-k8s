package com.cloud.k8s.springcloudk8s.basic;

public class InstanceOfDemo {

    static class Father{

    }

    static class Son extends Father{

    }

    public static void main(String[] args) {

        Son son = new Son();

        System.out.println(son instanceof Father);
        System.out.println(son instanceof Son);
    }
}
