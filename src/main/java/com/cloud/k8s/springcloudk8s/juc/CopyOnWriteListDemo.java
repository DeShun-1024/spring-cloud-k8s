package com.cloud.k8s.springcloudk8s.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListDemo {


    /**
     * ConcurrentModificationException
     */
    public void unSafeList() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list1.add(UUID.randomUUID().toString().substring(3));
                System.out.println(list1);
            }).start();
        }

    }

    public static void main(String[] args) {

        CopyOnWriteListDemo demo = new CopyOnWriteListDemo();
        demo.unSafeList();
        List<String> list1 = new CopyOnWriteArrayList<>();

    }
}
