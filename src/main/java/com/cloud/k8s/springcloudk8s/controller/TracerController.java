package com.cloud.k8s.springcloudk8s.controller;

//import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/trace")
public class TracerController {

//    @Autowired
//    private Tracer tracer;
//
//    @GetMapping
//    public void test() {
//        log.info("trace...");
//        final String traceId = tracer.currentSpan().context().traceIdString();
//        System.out.println(traceId);
//    }
}
