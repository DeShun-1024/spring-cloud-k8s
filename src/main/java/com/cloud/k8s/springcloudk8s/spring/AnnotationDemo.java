package com.cloud.k8s.springcloudk8s.spring;

import com.alibaba.fastjson.JSON;
import com.cloud.k8s.springcloudk8s.spring.bean.MyFeign;
import com.cloud.k8s.springcloudk8s.spring.bean.MyFeignFactoryBean;
import com.cloud.k8s.springcloudk8s.spring.processor.MyBeanFactoryPostProcessor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;


@Data
@Slf4j

public class AnnotationDemo {

    private String parameter = "11";


    public static void testContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();


        GenericApplicationContext fatherContext = new GenericGroovyApplicationContext();


        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();

        context.getStartupDate();


    }

    public void beanFactoryPostProcess(){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());
        context.registerBean(AnnotationDemo.class);

        context.refresh();

        final Object test = context.getBean("annotationDemo");
        log.info("获取Bean:{}", JSON.toJSONString(test));
    }

    public static void factoryBeanAndBeanDefinition(){
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyFeignFactoryBean.class);
        context.refresh();
        final MyFeign bean = context.getBean(MyFeign.class);

        bean.test();
    }

    public static void main(String[] args) {
        factoryBeanAndBeanDefinition();
    }

}
