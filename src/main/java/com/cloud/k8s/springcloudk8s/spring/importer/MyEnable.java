package com.cloud.k8s.springcloudk8s.spring.importer;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 可以自定义enable来导入bean，可以利用注解中的元数据，可以对导入的bean做一些扩展，比如满足什么条件才导入
 *
 * @author hudeshun
 * @since 2022/1/29 10:47
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(MyEnableImport.class)
public @interface MyEnable {

    boolean needBean() default false;
}
