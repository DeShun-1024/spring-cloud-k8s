package com.cloud.k8s.springcloudk8s.juc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal threadLocal  = new ThreadLocal();
        threadLocal.set("");


        ArrayList<String> list = new ArrayList<>();
        list.add("1");


        Map<String,String> map = new HashMap<>();
        final Set<String> strings = map.keySet();

    }
}
