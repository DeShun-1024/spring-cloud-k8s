package com.cloud.k8s.springcloudk8s.spring.customize;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContextInitializer;

public class MyApplicationContextInitializer implements ApplicationContextInitializer<AnnotationConfigServletWebServerApplicationContext> {


    /**
     * 可以想到的场景可能为，在最开始激活一些配置，或者利用这时候class还没被类加载器加载的时机，进行动态字节码注入等操作
     */
    @Override
    public void initialize(AnnotationConfigServletWebServerApplicationContext applicationContext) {

        System.out.println("容器初始化之前执行");
    }
}
