package com.cloud.k8s.springcloudk8s.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;


/**
 * PriorityOrdered 优先 Ordered 处理。
 *
 * @author hudeshun
 * @since 2022/1/26 14:34
 */
public class MyBeanFactoryPostProcessorOrder implements PriorityOrdered, BeanFactoryPostProcessor {
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("有顺序的，要优先执行");
    }
}
