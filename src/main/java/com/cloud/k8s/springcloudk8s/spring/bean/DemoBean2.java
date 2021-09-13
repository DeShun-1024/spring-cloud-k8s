package com.cloud.k8s.springcloudk8s.spring.bean;


import org.springframework.stereotype.Component;

public class DemoBean2 extends DemoBean{

    @Override
    public String get() {
        return "第二代";
    }
}
