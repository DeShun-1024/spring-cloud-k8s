package com.cloud.k8s.springcloudk8s.spring.customize;

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
 */

@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    /**
     * 实例化之前
     * 返回一个代理对象
     * <p>
     * spring 中实例化bean
     * {@link AbstractAutowireCapableBeanFactory#resolveBeforeInstantiation}
     * {@link AbstractAutowireCapableBeanFactory#createBean} 505
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (beanName.equals("instantiationAware")) {
            System.out.println("执行postProcessBeforeInstantiation...");
            final InstantiationAwareImpl target = new InstantiationAwareImpl();
            final InstantiationAwareInvoker invoker = new InstantiationAwareInvoker(target);

            final Object proxyInstance = Proxy.newProxyInstance(InstantiationAware.class.getClassLoader(), new Class[]{InstantiationAware.class}, invoker);

            // 直接返回代理对象
            return proxyInstance;
        }

        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 实例化 之后
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
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
