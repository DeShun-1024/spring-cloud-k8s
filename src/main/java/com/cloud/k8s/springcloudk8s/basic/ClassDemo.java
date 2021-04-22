package com.cloud.k8s.springcloudk8s.basic;

public class ClassDemo {

    public static void loader() {
        final Class<ClassDemo> classDemoClass = ClassDemo.class;
        final ClassLoader classLoader = classDemoClass.getClassLoader();

        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader == systemClassLoader);
    }


    public static void main(String[] args) {

        loader();
    }
}
