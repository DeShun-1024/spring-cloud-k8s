package com.cloud.k8s.springcloudk8s.pattern;

/**
 * 代理模式
 * 代理模式的主要角色如下。
 * 1、抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 * 2、真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 * 3、代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 */
public class ProxyDemo {

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }


    /**
     * 抽象主题
     */
    public interface Subject {
        void Request();
    }

    /**
     * 真实主题
     */
    static class RealSubject implements Subject {

        @Override
        public void Request() {
            System.out.println("真实主题");
        }
    }

    /**
     * 代理
     */
    static class Proxy implements Subject {

        private RealSubject realSubject;

        @Override
        public void Request() {
            if (realSubject == null) {
                realSubject = new RealSubject();
            }

            beforeSubject();

            realSubject.Request();

            afterSubject();
        }

        public void beforeSubject() {
            System.out.println("在执行之前...");
        }

        public void afterSubject() {
            System.out.println("在执行之后...");
        }

    }

}
