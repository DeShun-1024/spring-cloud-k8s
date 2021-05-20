package com.cloud.k8s.springcloudk8s.basic;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    /**
     * key存在，返回value；不存在，返回null
     */
    public static void mapRemove() {
        Map<String, String> map = new HashMap<>();

        map.put("key", "value");

        final String test = map.remove("test");
        System.out.println(test);

        final String key = map.remove("key");
        System.out.println(key);

        System.out.println(map);

    }

    public static void changeDemo(){
        Map<String,String>  map = new HashMap<>();
        map.put("1","1");


        Map<String,String> map1 = map;
        map1.put("2","2");

        System.out.println(map);
    }

    public static void main(String[] args) {
        changeDemo();
    }
}
