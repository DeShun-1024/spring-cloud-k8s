package com.cloud.k8s.springcloudk8s.spring.condition;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MyConditionOn(testValue = "OK")
public class MyConditionTest {


    @Bean
    public ConditionBean conditionBean() {
        return new ConditionBean().setName("OK");
    }


}
