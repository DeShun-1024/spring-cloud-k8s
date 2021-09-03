package com.cloud.k8s.springcloudk8s.spring.importer;

import com.cloud.k8s.springcloudk8s.spring.bean.MyFeign;
import com.cloud.k8s.springcloudk8s.spring.bean.MyFeignFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 1、使用factoryBean来自定义bean的实现方式，创建类的动态代理对象
 * 2、实现spring的bean扩展接口，自定义bena的定义信息，并执行这些bean的生成方式；
 * 3、此时是可以通过factoryBean来设置bean的生成方式的
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyFeignFactoryBean.class);

        // BY type
        definitionBuilder.setAutowireMode(2);
        final AbstractBeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();
        beanDefinition.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, MyFeign.class);

        // 为什么 @Autowired 会直接注入这个bean？bean默认是单例
        registry.registerBeanDefinition("myTestFeignClass", beanDefinition);

    }
}
