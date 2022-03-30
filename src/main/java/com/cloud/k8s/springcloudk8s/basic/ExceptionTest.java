package com.cloud.k8s.springcloudk8s.basic;

import lombok.Data;

public class ExceptionTest {


    public static void test_1(){

        Student student = new Student();
        student.setName("A");

        try {
            student.setName("B");
            System.out.println(1/0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(student.getName());
    }

    public static void main(String[] args) {
        test_1();
    }



    @Data
    private static class Student{
        private String name;
    }
}
