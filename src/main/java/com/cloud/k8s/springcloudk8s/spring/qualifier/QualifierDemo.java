package com.cloud.k8s.springcloudk8s.spring.qualifier;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class QualifierDemo {


    @MyQualifier
    @Bean
    public RestTemplate restTemplate1() {
        return new RestTemplate();
    }


    @Bean
    public RestTemplate restTemplate2() {
        return new RestTemplate();
    }
}
