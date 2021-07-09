package com.cloud.k8s.springcloudk8s.juc;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列的特点：
 * 存放：如果队列已满，当前操作阻塞，
 * 读取：如果队列没有数据，读取阻塞
 * 有对应的处理方法
 *
 * @author hudeshun
 * @since 2021/4/2 16:54
 */
public class BlockingQueueDemo {

    /**
     * add、remove 抛出异常
     */
    public static void exception() throws InterruptedException {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("1");
        queue.add("2");
        queue.add("3");

//        queue.add("4");

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
    }

    /**
     * offer、poll不会出现异常
     */
    public static void withoutException() throws InterruptedException {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("1"));
        System.out.println(queue.offer("1"));


        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }


    /**
     * put、take 一直阻塞
     */
    public static void block() throws InterruptedException {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.put("1");
        queue.put("1");
        queue.put("1");

//        queue.put("1");

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());
    }

    /**
     * offer、poll 时间参数设定阻塞时间
     */
    public static void blockInLimit() throws InterruptedException {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.offer("1");
        queue.offer("1");
        queue.offer("1");
//        queue.offer("1", 2L, TimeUnit.SECONDS);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll(2L, TimeUnit.SECONDS));
    }


    /**
     * 获取对首元素、但是不移除；
     * element-如果没有就异常；
     * peek-如果没有返回null
     */
    public static void getFist() {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
        queue.add("2");
        queue.poll();

        // 没有数据就异常
//        System.out.println(queue.element());

        System.out.println(queue.peek());
    }

    public static void main(String[] args) throws InterruptedException {
//        exception();

        withoutException();

//        block();

//        blockInLimit();

//        getFist();
    }
}
