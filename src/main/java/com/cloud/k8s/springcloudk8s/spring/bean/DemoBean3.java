package com.cloud.k8s.springcloudk8s.spring.bean;

import org.springframework.stereotype.Service;


@Service("b")
public class DemoBean3 extends DemoBean2 {

    @Override
    public String get() {
        return "第三代";
    }
}
