package com.cloud.k8s.springcloudk8s.spring.sleuth;


import com.cloud.k8s.springcloudk8s.controller.TracerController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.instrument.async.TraceableExecutorService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class MyTraceableExecutorService {


    @Autowired
    private BeanFactory beanFactory;


    /**
     * 配合线程池使用
     * <p>
     * {@link TracerController#test1()}
     */
    @Bean
    public TraceableExecutorService traceableExecutorService() {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);
        return new TraceableExecutorService(beanFactory, executorService);
    }


    public void normalExecutor() throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                log.info(Thread.currentThread().getName());
            });
        }


        TimeUnit.SECONDS.sleep(1);

        executorService.shutdown();

    }

}
