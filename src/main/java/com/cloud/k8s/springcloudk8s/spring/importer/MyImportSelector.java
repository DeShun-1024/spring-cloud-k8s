package com.cloud.k8s.springcloudk8s.spring.importer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportSelector implements ImportSelector {


    /**
     * 返回需要注入的bean
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ImportBeanDemo.class.getName()};
    }


}
