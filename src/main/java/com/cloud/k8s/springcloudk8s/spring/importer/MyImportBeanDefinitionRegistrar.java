package com.cloud.k8s.springcloudk8s.spring.importer;

import com.cloud.k8s.springcloudk8s.spring.feign.MyFeign;
import com.cloud.k8s.springcloudk8s.spring.feign.MyFeignFactoryBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 动态注册Bean
 *
 * 1、使用factoryBean来自定义bean的实现方式，创建类的动态代理对象
 * 2、实现spring的bean扩展接口，自定义bena的定义信息，并执行这些bean的生成方式；
 * 3、此时是可以通过factoryBean来设置bean的生成方式的
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     * 与ImportSelector想比较，改方法对于bean可以做更多定制。
     * 例如，{@link org.springframework.cloud.openfeign.EnableFeignClients}，注入一类bean
     *
     *
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        BeanDefinitionBuilder definitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyFeignFactoryBean.class);

        // BY type
        definitionBuilder.setAutowireMode(2);
        final AbstractBeanDefinition beanDefinition = definitionBuilder.getBeanDefinition();

        // 这里使用FactoryBean.OBJECT_TYPE_ATTRIBUTE，在后续bean的实例化过程中，会使用MyFeignFactoryBean来完成bean实例化
        beanDefinition.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, MyFeign.class);

        // 为什么 @Autowired 会直接注入这个bean？bean默认是单例
        registry.registerBeanDefinition("myTestFeignClass", beanDefinition);

    }
}
