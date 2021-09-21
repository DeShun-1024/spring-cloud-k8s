package com.cloud.k8s.springcloudk8s.juc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class MyThreadPoolTaskExecutor {


    public static void test1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);

        List<String> list = new ArrayList<>();

        log.info("11");

        for (int i = 1; i < 3; i++) {

            new Thread(() -> {
                try {
                    list.add(Thread.currentThread().getName());
                    TimeUnit.SECONDS.sleep(5);
                    log.info(Thread.currentThread().getName() + "执行完成");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();

        log.info("22.{}");


        System.out.println(list);

    }

    public static void test2() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(50);
        executor.setKeepAliveSeconds(600);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        log.info("开始");

        final Future<Integer> submit = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(3);
            return 3;
        });

        final Future<Integer> submit2 = executor.submit(() -> {
            TimeUnit.SECONDS.sleep(6);
            return 10;
        });
        log.info("------");

        log.info("结束.{}", (submit.get() + submit2.get(2, TimeUnit.SECONDS)));

        executor.shutdown();
    }


    /**
     * 批量提交任务
     * 超时中断异常
     */
    public static void test3() throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(4);
        executor.setMaxPoolSize(30);
        executor.setQueueCapacity(50);
        executor.setKeepAliveSeconds(600);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();


        List<Callable<List<Integer>>> tasks = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            final int a = i;
            Callable<List<Integer>> callable = () -> {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                if (a == 50) {
                    TimeUnit.SECONDS.sleep(5L);
                }
                return list;
            };

            tasks.add(callable);
        }

        log.info("----提交");
        final List<Future<List<Integer>>> futures = executor.getThreadPoolExecutor().invokeAll(tasks, 4, TimeUnit.SECONDS);

        log.info("----获取");
        for (Future<List<Integer>> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        test3();

    }
}