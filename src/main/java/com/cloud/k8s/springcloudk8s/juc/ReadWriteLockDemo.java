package com.cloud.k8s.springcloudk8s.juc;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.RandomStringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


/**
 * 读写锁，写的时候独占，读的时候多线程读
 *
 * @author hudeshun
 * @since 2021/4/2 16:24
 */
@Data
@Slf4j
class CacheMapWithLock {

    private Map<String, String> cache = new HashMap<>();

    final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    public void write(String key, String value) {
        final Lock lock = readWriteLock.writeLock();
        lock.lock();
        try {
            log.info("线程：{} 开始写入", Thread.currentThread().getName());
            cache.put(key, value);
            log.info("线程：{} 写入OK", Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void read(String key) {
        final Lock lock = readWriteLock.readLock();
        lock.lock();
        try {
            log.info("线程：{} 开始读取", Thread.currentThread().getName());
            final String value = cache.get(key);
            log.info("线程：{} 读取OK. key:{}  value:{}", Thread.currentThread().getName(), key, value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}


@Data
@Slf4j
class CacheMap {

    private Map<String, String> cache = new HashMap<>();

    public void write(String key, String value) {
        log.info("线程：{} 开始写入", Thread.currentThread().getName());
        cache.put(key, value);
        log.info("线程：{} 写入OK", Thread.currentThread().getName());
    }

    public void read(String key) {
        log.info("线程：{} 开始读取", Thread.currentThread().getName());
        final String value = cache.get(key);
        log.info("线程：{} 读取OK.{}", Thread.currentThread().getName(), value);
    }
}

@Slf4j
public class ReadWriteLockDemo {

    public static void readWriteLock() {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    }

    public static void main(String[] args) throws InterruptedException {
        CacheMap cacheMap = new CacheMap();

        CacheMapWithLock cacheMapWithLock = new CacheMapWithLock();

        for (int i = 1; i <= 10; i++) {
            final String key = i + "";
            new Thread(() -> {
                cacheMapWithLock.write(key, RandomStringUtils.random(2));
            }).start();
        }

        TimeUnit.SECONDS.sleep(3L);

        for (int i = 1; i <= 10; i++) {
            final String key = i + "";
            new Thread(() -> {
                cacheMapWithLock.read(key);
            }).start();
        }

        for (int i = 1; i <= 10; i++) {
            final String key = i + "";
            new Thread(() -> {
                cacheMapWithLock.read(key);
            }).start();
        }
    }
}



