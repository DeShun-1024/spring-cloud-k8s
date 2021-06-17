package com.cloud.k8s.springcloudk8s.basic;

import java.lang.reflect.Field;

public class FieldDemo {

    private String state = "name";

    public static void main(String[] args) throws Exception {
        final Field state = FieldDemo.class.getDeclaredField("state");

    }
}
