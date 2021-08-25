package com.cloud.k8s.springcloudk8s.spring;

import com.cloud.k8s.springcloudk8s.spring.customize.MyBeanFactoryPostProcessorOrder;
import org.springframework.beans.factory.annotation.Autowired;

public class AutowireDemo {

    @Autowired
    private MyBeanFactoryPostProcessorOrder myBeanFactoryPostProcessorOrder;
}
