package com.cloud.k8s.springcloudk8s.spring.bean;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Primary
@Service("a")
public class DemoBean2 implements DemoBean{

    @Override
    public String get() {
        return "第二代";
    }
}
