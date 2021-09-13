package com.cloud.k8s.springcloudk8s.controller;


import com.cloud.k8s.springcloudk8s.spring.feign.WeChatFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    private WeChatFeign weChatFeign;

    @GetMapping("/test")
    public String test() {
        return weChatFeign.test();
    }
}
