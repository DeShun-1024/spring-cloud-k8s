package com.cloud.k8s.springcloudk8s.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Configuration;


/**
 * 在spring容器启动后，加载自己的组件信息
 */
@Slf4j
@Configuration
public class MySmartLifecycle implements SmartLifecycle {

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void start() {
        log.info("自定义 【SmartLifecycle】启动自定义组件 执行方法 start()");
    }

    @Override
    public void stop() {
        log.info("自定义 【SmartLifecycle】关闭自定义组件");
    }
}
