package com.cloud.k8s.springcloudk8s.spring.importer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

@Slf4j
public class MyEnableImport implements ImportSelector {

    /**
     * 可以根据注解中数据，来约束实例化bean行为
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        final Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyEnable.class.getName(), true);

        log.info("自定义 enable 。{}", annotationAttributes);

        return new String[0];
    }
}
