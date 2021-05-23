package com.cloud.k8s.springcloudk8s.basic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RefunceDemo {

    private List<String> list = new ArrayList<>();

    public void test(){

        final List<String> after = this.list;
        this.list = null;

        System.out.println(after==null);
    }

    public static void main(String[] args) {
        RefunceDemo demo = new RefunceDemo();

        demo.test();

    }
}
