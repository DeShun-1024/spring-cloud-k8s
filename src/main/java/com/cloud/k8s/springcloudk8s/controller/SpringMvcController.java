package com.cloud.k8s.springcloudk8s.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mvc")
@Slf4j
public class SpringMvcController {

    @PostMapping("/test")
    public void test(@RequestBody List<Integer> ids) {
        log.info("{}", ids);
    }
}
