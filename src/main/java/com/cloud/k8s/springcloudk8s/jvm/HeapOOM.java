package com.cloud.k8s.springcloudk8s.jvm;

import java.util.ArrayList;
import java.util.List;


/**
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/hudeshun/Downloads
 */
public class HeapOOM {

    static class OOMObejct {

    }


    public static void main(String[] args) {
        List<OOMObejct> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObejct());
        }
    }
}
