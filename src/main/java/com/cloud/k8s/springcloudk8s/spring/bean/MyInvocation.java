package com.cloud.k8s.springcloudk8s.spring.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocation implements InvocationHandler {


    /**
     * debug 模式下，因为IDE收集变量值，需要调用toString方法。由于又是代理类，所以会一直执行该方法。
     *
     * 在正常模式下，正常调用
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(Thread.currentThread().getName() + "拦截..." + proxy.getClass().getTypeName() + ";" + method.getName());

        return null;
    }
}
