package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.bean.MyFeign;
import com.cloud.k8s.springcloudk8s.spring.condition.ConditionBean;
import com.cloud.k8s.springcloudk8s.spring.condition.MyConditionComponentDemo;
import com.cloud.k8s.springcloudk8s.spring.processor.MyInstantiationAwareBeanPostProcessor;
import com.cloud.k8s.springcloudk8s.spring.qualifier.MyQualifier;
import com.cloud.k8s.springcloudk8s.spring.qualifier.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping
public class TestController {

    @Autowired
    private MyFeign myFeignFactoryBean;

    @Autowired
    private ConditionBean conditionBean;

    @Autowired
    private List<RestTemplate> restTemplates1;

    @Autowired
    @MyQualifier
    private RestTemplate restTemplates2;

    @Autowired
    private MyConditionComponentDemo conditionComponentDemo;

    @Autowired
    @MyQualifier
    private ServiceDemo serviceDemo;

    @Autowired
    private List<ServiceDemo> serviceDemos;

    @Autowired
    private List<MyInstantiationAwareBeanPostProcessor.InstantiationAware> instantiationAwares;


    @GetMapping("/test")
    public void test() {
        myFeignFactoryBean.test();
    }

    @GetMapping("/conditionBean")
    public void conditionBean() {
        System.out.println(conditionBean.getName());
    }

    @GetMapping("/myQualifier")
    public void myQualifier() {
        System.out.println(serviceDemo);
        System.out.println(serviceDemos);
    }

    @GetMapping("/conditionComponentDemo")
    public void conditionComponentDemo(){
        conditionComponentDemo.test();
    }

    @GetMapping("/instantiationAware")
    public void instantiationAware(){
        for (MyInstantiationAwareBeanPostProcessor.InstantiationAware instantiationAware : instantiationAwares) {
            instantiationAware.name();
        }
    }


}
