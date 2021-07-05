package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.bean.MyFeign;
import com.cloud.k8s.springcloudk8s.spring.condition.ConditionBean;
import com.cloud.k8s.springcloudk8s.spring.qualifier.MyQualifier;
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
    private List<RestTemplate> restTemplates2;


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
        System.out.println(restTemplates1);
        System.out.println("********");
        System.out.println(restTemplates2);
    }


}
