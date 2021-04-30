package com.cloud.k8s.springcloudk8s.basic;


import lombok.extern.slf4j.Slf4j;

/**
 * 关于stirng类，改类是不可变类，线程安全，
 * <p>
 * string中replace、substring 操作的都是副本
 *
 * @author hudeshun
 * @since 2021/4/26 11:09
 */

@Slf4j
public class StringDemo {

    public static void testSub() {
        String str = new String("12345678904444444");

        new Thread(() -> {
            final String substring = str.substring(2);

            log.info("截取结果：");
            System.out.println(substring);
        }).start();

        new Thread(() -> {
            final String substring = str.substring(11);

            log.info("截取结果：");
            System.out.println(substring);
        }).start();

        System.out.println("原始数据：" + str);

    }


    public static void main(String[] args) {
        testSub();
    }
}
