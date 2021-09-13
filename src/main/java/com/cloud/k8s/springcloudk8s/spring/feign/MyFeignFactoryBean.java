package com.cloud.k8s.springcloudk8s.spring.feign;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class MyFeignFactoryBean implements FactoryBean<Object> {

    @Override
    public Object getObject() throws Exception {
        System.out.println("my factory bean 初始化....");

        final Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{getObjectType()}, new MyInvocation());

        return  o;
    }

    @Override
    public Class<?> getObjectType() {
        return MyFeign.class;
    }


    public void test(){
        System.out.println("MyFeignFactoryBean");
    }
}
