package com.cloud.k8s.springcloudk8s.basic;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map 的 keyset、values、entrySet都不支持add，因为这些方法返回的都是HashMap中的内部类，而这些类都继承了对应的抽象类，没有实现add方法
 */
public class MapUnsupportedOperationException {

    public static void entrySet() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        // java.util.HashMap.EntrySet
        final Set<Map.Entry<String, String>> entries = map.entrySet();

        System.out.println(entries);
    }

    public static void valueSet() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");
        // java.util.HashMap.Values 该类同样不支持add
        final Collection<String> values = map.values();
    }

    public static void keySet() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        // 这里返回的是 java.util.HashMap.KeySet，该类不支持add方法
        final Set<String> keySet = map.keySet();

        keySet.add("4");
    }

    public static void main(String[] args) {
        entrySet();
    }
}
