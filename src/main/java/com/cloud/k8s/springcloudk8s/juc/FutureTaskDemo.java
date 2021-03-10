package com.cloud.k8s.springcloudk8s.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Task());

        // 使用线程
        new Thread(futureTask).start();

        final String s = futureTask.get();

        System.out.println(s);


    }

}

class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "callable";
    }
}