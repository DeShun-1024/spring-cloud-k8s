package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.AutowireDemo;
import com.cloud.k8s.springcloudk8s.spring.bean.MyFeign;
import com.cloud.k8s.springcloudk8s.spring.bean.MyFeignFactoryBean;
import com.cloud.k8s.springcloudk8s.spring.condition.ConditionBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {


    @Autowired
    private MyFeign myFeignFactoryBean;

    @Autowired
    private ConditionBean conditionBean;



    @GetMapping("/test")
    public void test(){
        myFeignFactoryBean.test();
    }



    @GetMapping("/conditionBean")
    public void conditionBean(){
        System.out.println(conditionBean.getName());
    }


}
