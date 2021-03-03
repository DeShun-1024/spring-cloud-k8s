package com.cloud.k8s.springcloudk8s.jvm;

public class RAM_3 {

    private static final int _1MB = 1024 * 1024;

    /**
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1
     * -XX:+PrintTenuringDistribution  JVM 在每次新生代GC时，打印出幸存区中对象的年龄分布。
     * -XX:+UseSerialGC
     */
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3;

        allocation1 = new byte[_1MB /4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];

        allocation3 = null;

        allocation3 = new byte[4 * _1MB];
    }
}
