package com.cloud.k8s.springcloudk8s.spring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        final Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(MyConditionOn.class.getName());

        if (annotationAttributes != null) {
            final Object object = annotationAttributes.get("testValue");

            if (object instanceof String) {
                return object.equals("OK");
            }
        }
        return false;
    }
}
