package com.cloud.k8s.springcloudk8s.spring.importer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import javax.annotation.Nonnull;

public class MyImportSelector implements ImportSelector {


    /**
     * 返回需要注入的bean
     */
    @Override
    @Nonnull
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ImportBeanDemo.class.getName()};
    }


}
