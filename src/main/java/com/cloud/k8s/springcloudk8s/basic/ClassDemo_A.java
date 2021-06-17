package com.cloud.k8s.springcloudk8s.basic;

import com.alibaba.fastjson.JSON;

class ClassDemo_A extends ClassDemo {


    private String name = "子类";
    static {
        System.out.println("子类 static");
    }

    public ClassDemo_A() {
        System.out.println("ClassDemo_A");
    }


    public void test(ClassDemo classDemo){

    }
    public static void main(String[] args) {
        ClassDemo classDemo = new ClassDemo_A();


        System.out.println(JSON.toJSONString(classDemo));
    }
}