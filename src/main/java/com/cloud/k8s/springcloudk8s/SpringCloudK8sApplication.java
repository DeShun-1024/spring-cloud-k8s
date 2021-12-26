package com.cloud.k8s.springcloudk8s;

import com.cloud.k8s.springcloudk8s.spring.importer.MyImportBeanDefinitionRegistrar;
import com.cloud.k8s.springcloudk8s.spring.importer.MyImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

//@EnableCircuitBreaker
//@EnableEurekaServer
//@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableScheduling
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
public class SpringCloudK8sApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringCloudK8sApplication.class, args);
    }

}
