package com.cloud.k8s.springcloudk8s.spring.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * BeanDefinitionRegistryPostProcessor
     * <p>
     * 一般用于定制化bean定义，bean定义的扩展点
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        System.out.println("BeanDefinitionRegistryPostProcessor 会优先执行:" + LocalDateTime.now());
    }


    /**
     * BeanFactoryPostProcessor
     * <p>
     * 工厂标准初始化后，针对工厂的扩展点
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor 会在之后优先执行:" + LocalDateTime.now());

    }
}
