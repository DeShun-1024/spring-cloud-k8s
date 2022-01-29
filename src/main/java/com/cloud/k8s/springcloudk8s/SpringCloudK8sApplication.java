package com.cloud.k8s.springcloudk8s;

import com.cloud.k8s.springcloudk8s.spring.importer.MyEnable;
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
/* 直接import */
@Import({MyImportBeanDefinitionRegistrar.class, MyImportSelector.class})
/* 自定义enable 注入，相比较于@Import更加灵活*/
@MyEnable(needBean = true)
public class SpringCloudK8sApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudK8sApplication.class, args);
    }

}
