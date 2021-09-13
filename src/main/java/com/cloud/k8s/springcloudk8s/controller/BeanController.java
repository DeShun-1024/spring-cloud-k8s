package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.bean.DemoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class BeanController {

    private DemoBean demoBean;


    public String test(){
        return demoBean.get();
    }
}
