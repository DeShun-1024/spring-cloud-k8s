package com.cloud.k8s.springcloudk8s.jvm;

public class RAM_2 {

    private final static int _1M = 1024 * 1024;

    public static void main(String[] args) {
        // -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8  -XX:PretenureSizeThreshold=3145728
        byte[] allocation1;
        allocation1 = new byte[6 * _1M];

    }
}
