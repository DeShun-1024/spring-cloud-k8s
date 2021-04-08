package com.cloud.k8s.springcloudk8s.voli;

import java.util.concurrent.TimeUnit;



/**
 *
 * @author hudeshun
 * @since 2021/4/6 12:48
 */
public class MemoryDemo {

    private static int flag = 0;
    private static volatile int flagWithVol = 0;


    public static void without() throws InterruptedException {
        new Thread(() -> {
            while (flag == 0) {

            }
        }).start();

        TimeUnit.SECONDS.sleep(1L);

        flag = 1;

        System.out.println(flag);

    }

    public static void withVolatile() throws InterruptedException {
        new Thread(() -> {
            while (flagWithVol == 0) {

            }
        }).start();

        TimeUnit.SECONDS.sleep(1L);

        flagWithVol = 1;

        System.out.println(flagWithVol);

    }




    public static void main(String[] args) throws InterruptedException {
//        without();
        withVolatile();
    }
}
