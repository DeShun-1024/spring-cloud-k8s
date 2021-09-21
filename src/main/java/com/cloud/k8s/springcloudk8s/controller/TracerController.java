package com.cloud.k8s.springcloudk8s.controller;

import brave.Tracer;
import com.cloud.k8s.springcloudk8s.spring.sleuth.MyTraceableExecutorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping("/trace")
public class TracerController {

    @Autowired
    private Tracer tracer;

    @Autowired
    private MyTraceableExecutorService myTraceableExecutorService;

    @Autowired
    private TraceableExecutorService traceableExecutorService;

    @GetMapping
    public void test() {
        log.info("trace...");
        final String traceId = tracer.currentSpan().context().traceIdString();
        System.out.println(traceId);
    }


    @GetMapping("/test1")
    public void test1() throws InterruptedException {
        log.info("trace...");
        for (int i = 0; i < 10; i++) {
            traceableExecutorService.execute(() -> {
                log.info("trace ");
            });
        }
        TimeUnit.SECONDS.sleep(5);

        myTraceableExecutorService.normalExecutor();
    }


}
