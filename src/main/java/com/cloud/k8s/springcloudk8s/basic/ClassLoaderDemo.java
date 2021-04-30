package com.cloud.k8s.springcloudk8s.basic;

import java.lang.reflect.Constructor;


public class ClassLoaderDemo {

    private int a = 10;

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                return super.loadClass(name);
            }
        };

        final Class<?> aClass = classLoader.loadClass("com.cloud.k8s.springcloudk8s.basic.ClassLoaderDemo");

        final Constructor<?> constructor = aClass.getConstructor();
        final ClassLoaderDemo o = (ClassLoaderDemo) constructor.newInstance();

        System.out.println(o.a);
    }
}
