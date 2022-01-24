package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.bean.DemoBean;
import com.cloud.k8s.springcloudk8s.spring.processor.MyBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/bean")
public class BeanController {


    @Autowired
    private DemoBean demoBean;

    @Autowired
    private MyBeanPostProcessor.MyBeanPostProcessorBean myBeanPostProcessorBean;


    @GetMapping
    public String test() {
        return demoBean.get();
    }

    @GetMapping("/myBeanPostProcessorBean")
    public String bean() {
        return myBeanPostProcessorBean.getBeanName();
    }
}
