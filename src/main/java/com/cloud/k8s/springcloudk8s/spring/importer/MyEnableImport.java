package com.cloud.k8s.springcloudk8s.spring.importer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

@Slf4j
public class MyEnableImport implements ImportSelector {

    /**
     * 可以根据注解中数据，来约束实例化bean行为
     * <p>
     * 这里返回是需要加载的类名称
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        final Map<String, Object> annotationMap = importingClassMetadata.getAnnotationAttributes(MyEnable.class.getName(), true);

        // 可以获取注解中的数据
        final AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(annotationMap);

        if (annotationAttributes != null) {
            final boolean needBean = annotationAttributes.getBoolean("needBean");
            if (needBean) {
                log.info("自定义 enable 。{}", annotationMap);
                return new String[]{MyEnableImportBean.class.getName()};
            }
        }
        return new String[0];
    }
}
