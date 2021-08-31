package com.cloud.k8s.springcloudk8s.spring.customize;

import org.springframework.context.SmartLifecycle;
import org.springframework.context.annotation.Configuration;


/**
 * 在spring容器启动后，加载自己的组件信息
 *
 */
@Configuration
public class MySmartLifecycle implements SmartLifecycle {

    @Override
    public boolean isRunning() {
        return false;
    }

    @Override
    public void start() {
        System.out.println("启动自己的组件");
    }

    @Override
    public void stop() {
        System.out.println("关闭自己的组件");
    }
}
