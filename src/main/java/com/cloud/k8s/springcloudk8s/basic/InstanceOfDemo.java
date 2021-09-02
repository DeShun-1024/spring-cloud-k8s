package com.cloud.k8s.springcloudk8s.basic;

public class InstanceOfDemo {


    interface InstanceFace{

    }

    static class Father implements InstanceFace{

    }

    static class Son extends Father{

    }

    public static void main(String[] args) {

        Son son = new Son();

        System.out.println(son instanceof Father);
        System.out.println(son instanceof Son);
        System.out.println(son instanceof InstanceFace);

    }
}
