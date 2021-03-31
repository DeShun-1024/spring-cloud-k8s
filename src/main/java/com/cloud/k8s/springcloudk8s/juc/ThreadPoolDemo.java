package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    private static void executorDemo(){
        final ExecutorService executorService = Executors.newCachedThreadPool();
    }
}
