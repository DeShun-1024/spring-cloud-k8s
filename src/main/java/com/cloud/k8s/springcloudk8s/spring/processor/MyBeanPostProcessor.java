package com.cloud.k8s.springcloudk8s.spring.processor;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Bean
    public MyBeanPostProcessorBean myBeanPostProcessorBean() {

        MyBeanPostProcessorBean bean = new MyBeanPostProcessorBean();
        bean.setBeanName("myBeanPostProcessorBean");
        return bean;
    }


    /**
     * 初始化之前
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("myBeanPostProcessorBean") && bean instanceof MyBeanPostProcessorBean) {
//            ((MyBeanPostProcessorBean) bean).setBeanName("postProcessBeforeInitialization");
            log.info("【MyBeanPostProcessor】postProcessBeforeInitialization bean name:{}", myBeanPostProcessorBean());
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    /**
     * 初始化之后
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Data
    public static class MyBeanPostProcessorBean {

        private String beanName;
    }

}
