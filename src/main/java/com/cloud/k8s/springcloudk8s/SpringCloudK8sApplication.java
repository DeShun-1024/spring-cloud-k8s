package com.cloud.k8s.springcloudk8s;

import com.cloud.k8s.springcloudk8s.spring.MyBeanPostProcessor;
import com.cloud.k8s.springcloudk8s.spring.bean.MyBeanDefinitionRegistry;
import com.cloud.k8s.springcloudk8s.spring.bean.MyFeignFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;


//@EnableEurekaServer
@EnableFeignClients
@SpringBootApplication
@Import(MyBeanDefinitionRegistry.class)
public class SpringCloudK8sApplication {




    public static void main(String[] args) {
        SpringApplication.run(SpringCloudK8sApplication.class, args);

    }

}
