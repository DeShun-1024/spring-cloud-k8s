package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.AutowireDemo;
import com.cloud.k8s.springcloudk8s.voli.MemoryDemo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {



    @GetMapping("/test")
    public void test(){
        AutowireDemo demo = new AutowireDemo();
        System.out.println();
    }

}
