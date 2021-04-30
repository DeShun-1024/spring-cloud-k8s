package com.cloud.k8s.springcloudk8s;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringCloudK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudK8sApplication.class, args);
    }

}
