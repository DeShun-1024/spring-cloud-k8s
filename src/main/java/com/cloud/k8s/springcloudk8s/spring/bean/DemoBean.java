package com.cloud.k8s.springcloudk8s.spring.bean;

public interface DemoBean {

    default String get(){
        return "初代";
    }
}
