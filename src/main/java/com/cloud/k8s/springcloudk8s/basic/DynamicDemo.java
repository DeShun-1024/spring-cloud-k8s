package com.cloud.k8s.springcloudk8s.basic;

import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicDemo {

    interface Test{
        void sout();
        void sout2();
    }

    static class TestImpl implements Test{

        @Override
        public void sout() {
            System.out.println("真实对象");
        }

        @Override
        public void sout2() {
            System.out.println("真实对象2");
        }
    }



    @Data
    static class DynamicObject implements InvocationHandler{

        private TestImpl test;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("111");

            System.out.println("2222");
            return method.invoke(test,args);
        }
    }


    public static void main(String[] args) {
        TestImpl real = new TestImpl();

        DynamicObject dynamicObject = new DynamicObject();
        dynamicObject.setTest(real);


        final Object proxyObject = Proxy.newProxyInstance(Test.class.getClassLoader(), real.getClass().getInterfaces(), dynamicObject);


        if (proxyObject instanceof Test){
            ((Test) proxyObject).sout();
        }



    }


}


