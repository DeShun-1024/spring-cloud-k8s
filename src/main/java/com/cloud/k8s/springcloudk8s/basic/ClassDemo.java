package com.cloud.k8s.springcloudk8s.basic;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Properties;

public class ClassDemo {

    static {
        System.out.println("父类 static");
    }

    public ClassDemo() {
        System.out.println("ClassDemo");
    }


    public static void loader() {
        final Class<ClassDemo> classDemoClass = ClassDemo.class;
        final ClassLoader classLoader = classDemoClass.getClassLoader();

        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader == systemClassLoader);
    }

    public static void resource() throws IOException {
        final ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        final URL resource = systemClassLoader.getResource("META-INF/spring.factories");

        final Object content = resource.getContent();
        final String file = resource.getFile();
        System.out.println(file);
        System.out.println(content.toString());

        UrlResource urlResource = new UrlResource(resource);
        Properties properties = PropertiesLoaderUtils.loadProperties(urlResource);

        System.out.println(properties);
    }

    public static void clazzDemo() throws Exception {
        final Class<?> aClass = Class.forName("com.cloud.k8s.springcloudk8s.basic.ClassDemo");


        final Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);
    }

    public static void main(String[] args) throws Exception {
        // 子类、父类初始化顺序，先创建父类，再创建子类；  static 在构造器之前执行
//        ClassDemo classDemo = new ClassDemo();
        // 出现子类引用的地方，可以用父类代替
//        ClassDemo classDemo1 = new ClassDemo_A();

        ClassDemo.clazzDemo();




    }
}
