package com.cloud.k8s.springcloudk8s.spring.processor;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Slf4j
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    /**
     * BeanDefinitionRegistryPostProcessor
     * <p>
     * 一般用于定制化bean定义，bean定义的扩展点
     */
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.info("自定义【BeanDefinitionRegistryPostProcessor】执行 postProcessBeanDefinitionRegistry 结束");
    }


    /**
     * BeanFactoryPostProcessor  这里的会优先与普通的BFPP
     * <p>
     * 工厂标准初始化后，针对工厂的扩展点
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("自定义【BeanDefinitionRegistryPostProcessor】覆盖BFPP 执行 postProcessBeanFactory 结束");


    }
}
