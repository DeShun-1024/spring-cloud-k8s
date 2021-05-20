package com.cloud.k8s.springcloudk8s.basic;

import lombok.Data;


@Data
public abstract class AbstracDemo {

    private String name;

    public AbstracDemo(String name) {
        this.name = name;
    }
}

class ClassA extends AbstracDemo{

    public ClassA() {
        super("");
    }
}


class ClassC{
    public static void main(String[] args) {


        ClassA classA = new ClassA();
        System.out.println(classA.getName());
    }
}


