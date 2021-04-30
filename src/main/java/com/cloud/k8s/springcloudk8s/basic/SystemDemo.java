package com.cloud.k8s.springcloudk8s.basic;

import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.Properties;

public class SystemDemo {

    public static void main(String[] args) {

        final Map<String, String> getenv = System.getenv();
        System.out.println(JSON.toJSONString(getenv));

        System.out.println("===========");
        final Properties properties = System.getProperties();
        System.out.println(JSON.toJSONString(properties));
    }
}
