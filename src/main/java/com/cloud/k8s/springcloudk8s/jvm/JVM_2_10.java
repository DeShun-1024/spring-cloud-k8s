package com.cloud.k8s.springcloudk8s.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class JVM_2_10 {

    private static final int _1MB = 1024*1024;

    /**
     * -Xmx20M -XX:MaxDirectMemorySize=10M
     */
    public static void main(String[] args) throws IllegalAccessException {
        final Field declaredField = Unsafe.class.getDeclaredFields()[0];
        declaredField.setAccessible(true);

        final Unsafe unsafe = (Unsafe)declaredField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
