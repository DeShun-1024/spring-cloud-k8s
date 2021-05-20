package com.cloud.k8s.springcloudk8s;

import com.cloud.k8s.springcloudk8s.spring.MyBeanPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class SpringCloudK8sApplication {


    @Autowired
    private MyBeanPostProcessor xxxxx;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudK8sApplication.class, args);
    }

}
