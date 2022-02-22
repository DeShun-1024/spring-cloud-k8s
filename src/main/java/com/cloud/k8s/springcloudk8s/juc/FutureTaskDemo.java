package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskDemo {



    public static void excutor() throws InterruptedException {
        final ExecutorService executorService = Executors.newFixedThreadPool(5);


        List<Callable<String>> tasks = new ArrayList<>();


        for (int i = 0; i <3; i++) {
            Callable futureTask = () -> {
                log.info(String.valueOf(System.currentTimeMillis()));
                return "null";
            };
            tasks.add(futureTask);
        }
        executorService.invokeAll(tasks);
    }

    public static void test() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Task());

        // 使用线程
        new Thread(futureTask).start();

        final String s = futureTask.get();

        System.out.println(s);
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {
        excutor();


    }

}

class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "callable";
    }
}