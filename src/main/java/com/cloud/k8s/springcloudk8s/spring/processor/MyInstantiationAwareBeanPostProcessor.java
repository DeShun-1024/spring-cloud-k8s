package com.cloud.k8s.springcloudk8s.spring.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 特殊的BPP，重写下面两个方法，如果返回不是null，将直接返回这个bean实例；
 * <p>
 * <p>
 * <p>
 * bean 实例化节点:
 * <p>
 * {@link AbstractAutowireCapableBeanFactory#doCreateBean} 594，
 * 这个方法是完成bena的实例化与初始化，
 * <p>
 * <p>
 * 这个相比较一般的BeanPostProcessor，会在实例化之前之前；
 *
 *
 *
 * spring的实例化与初始化；
 * 实例化：在spring的角度，实例化就是完成一个对象的创建；
 * 初始化：就是对这个实例化对象的属性组装；
 *
 * 但是在JVM中的周期是不同的；
 * 在JVM中首先需要把类的相关信息加载到虚拟机中，分配好内存，然后才能执行clinit方法创建对象。虚拟机初始化的，是指在创建对象前的初始化。
 *
 * 而spring的初始化，是指在对象new出来后，完成预先想设置的属性的过程称为初始化。
 *
 * 所以两者初始化所针对的场景不同。
 *
 */

@Slf4j
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化之前，这个时候对象是还没有new出来
     * 返回一个代理对象
     * <p>
     * spring 中实例化bean
     * {@link AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation}
     * {@link AbstractAutowireCapableBeanFactory#createBean} 505
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("instantiationAware")) {
            log.info("执行postProcessBeforeInstantiation...");
            final InstantiationAwareImpl target = new InstantiationAwareImpl();
            final InstantiationAwareInvoker invoker = new InstantiationAwareInvoker(target);

            final Object proxyInstance = Proxy.newProxyInstance(InstantiationAware.class.getClassLoader(), new Class[]{InstantiationAware.class}, invoker);

            // 直接返回代理对象
            return proxyInstance;
        }

        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 实例化 之后，已经完成对象的创建
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (beanName.equals("myBeanPostProcessorBean") && bean instanceof MyBeanPostProcessor.MyBeanPostProcessorBean) {
            ((MyBeanPostProcessor.MyBeanPostProcessorBean) bean).setBeanName("postProcessAfterInstantiation");
            log.info("【MyBeanPostProcessor】postProcessAfterInstantiation bean name:{}", beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    /**
     * 在bean实例化后，初始化之前，可以通过这个方法设置bean的属性
     * <p>
     * 执行时间节点:
     * <p>
     * {@link AbstractAutowireCapableBeanFactory#populateBean} 1420
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    public interface InstantiationAware {
        void name();
    }

    @Component("instantiationAware1")
    class InstantiationAwareImpl1 implements InstantiationAware {

        @Override
        public void name() {
            System.out.println("实例对象");
        }
    }

    @Component("instantiationAware")
    class InstantiationAwareImpl implements InstantiationAware {

        @Override
        public void name() {
            System.out.println("实例实验对象");
        }
    }


    class InstantiationAwareInvoker implements InvocationHandler {

        private InstantiationAware target;

        public InstantiationAwareInvoker(InstantiationAware target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("代理对象...执行前");
            method.invoke(target, args);
            return proxy;
        }
    }


}
