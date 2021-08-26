package com.cloud.k8s.springcloudk8s.spring.condition;


import org.springframework.stereotype.Component;

@Component
@MyConditionOn(testValue = "OK")
public class MyConditionComponentDemo {


    public void test() {
        System.out.println("MyConditionComponentDemo");
    }
}
