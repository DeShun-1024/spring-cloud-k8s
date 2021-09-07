package com.cloud.k8s.springcloudk8s.spring.spi;


import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

public class MySpringFactoriesLoaderImpl implements MySpringFactoriesLoader {

    @Override
    public String get() {
        return "MySpringFactoriesLoader";
    }

    public static void main(String[] args) {
        final List<MySpringFactoriesLoader> mySpringFactoriesLoaders = SpringFactoriesLoader.loadFactories(MySpringFactoriesLoader.class, MySpringFactoriesLoader.class.getClassLoader());

        for (MySpringFactoriesLoader mySpringFactoriesLoader : mySpringFactoriesLoaders) {
            System.out.println(mySpringFactoriesLoader.get());
        }
    }
}
