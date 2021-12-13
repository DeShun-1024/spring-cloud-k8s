package com.cloud.k8s.springcloudk8s;

import com.cloud.k8s.springcloudk8s.spring.importer.MyImportBeanDefinitionRegistrar;
import com.cloud.k8s.springcloudk8s.spring.importer.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

//@EnableCircuitBreaker
//@EnableEurekaServer
//@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
public class SpringCloudK8sApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudK8sApplication.class, args);
    }

}
