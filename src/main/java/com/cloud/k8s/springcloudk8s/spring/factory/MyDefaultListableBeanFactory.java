package com.cloud.k8s.springcloudk8s.spring.factory;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;

public class MyDefaultListableBeanFactory {



    public static void processorDemo(){


    }


    /**
     * spring 在初始化context时，会调用这个这个类的构造方法。
     * 所以在这个类的对象构建完成后，DefaultListableBeanFactory就已经创建完成。
     * <p>
     * <p>
     * AnnotationConfigServletWebServerApplicationContext父类方法中，完成了工厂的创建
     */
    public static void main(String[] args) {
        AnnotationConfigServletWebServerApplicationContext applicationContext = new AnnotationConfigServletWebServerApplicationContext();
        System.out.println(applicationContext.getDefaultListableBeanFactory().getBeanPostProcessors());
    }
}
