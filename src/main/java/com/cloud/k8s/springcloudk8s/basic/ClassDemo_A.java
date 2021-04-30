package com.cloud.k8s.springcloudk8s.basic;

class ClassDemo_A extends ClassDemo {

    static {
        System.out.println("子类 static");
    }

    public ClassDemo_A() {
        System.out.println("ClassDemo_A");
    }
}