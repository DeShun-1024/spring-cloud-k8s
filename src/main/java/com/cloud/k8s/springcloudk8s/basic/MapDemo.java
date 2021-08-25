package com.cloud.k8s.springcloudk8s.basic;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {


    /**
     * 遍历顺序与插入顺序相同，在LRU使用的缓存中
     */
    public static void linkedHashMapDemo() {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("f", "s");
        linkedHashMap.put("1f", "s");
        linkedHashMap.put("2f", "s");
        linkedHashMap.put("f5", "s");

        linkedHashMap.forEach((k, v) -> {
            System.out.println("K:" + k + "V:" + v);
        });
    }


    /**
     * KEY 按照自然排序
     */
    public static void treeMapDemo() {
        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("a", "1");
        treeMap.put("1a", "1");
        treeMap.put("ca", "1");
        treeMap.put("fa", "1");
        treeMap.put("ya", "1");
        treeMap.put("fa2", "1");
        treeMap.put("a1", "1");

        treeMap.forEach((k, v) -> {
            System.out.println("K:" + k + ",V:" + v);
        });
    }


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

    public static void changeDemo() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1");


        Map<String, String> map1 = map;
        map1.put("2", "2");

        System.out.println(map);
    }

    public static void main(String[] args) {
//        changeDemo();

//        treeMapDemo();

        linkedHashMapDemo();
    }
}
