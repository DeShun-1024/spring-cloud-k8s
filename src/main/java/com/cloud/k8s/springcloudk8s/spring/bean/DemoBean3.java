package com.cloud.k8s.springcloudk8s.spring.bean;

import org.springframework.stereotype.Component;

public class DemoBean3 extends DemoBean2 {

    @Override
    public String get() {
        return "第三代";
    }
}
