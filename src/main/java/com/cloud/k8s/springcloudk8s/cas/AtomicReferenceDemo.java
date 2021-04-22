package com.cloud.k8s.springcloudk8s.cas;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;


@Slf4j
public class AtomicReferenceDemo {

    /**
     * CAS
     */
    public static void atomicReferenceDemo() {
        AtomicReference<Integer> atomicReference = new AtomicReference<>(10);
        System.out.println(atomicReference.compareAndSet(10, 999));
    }


    /**
     * 带时间戳的CAS,
     * V
     * A
     * B
     */
    public static void atomicStampedReference() {
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(10, 10);
        log.info("更新之前:{}", stampedReference.getStamp());

        System.out.println(stampedReference.compareAndSet(10, 66, 10, 12));
        log.info("更新后，值:{}", stampedReference.getReference());
        log.info("更新后，时间戳:{}", stampedReference.getStamp());

    }

    /**
     * IntegerCache 问题，当值[-128,127]之间，integer是在IntegerCache中产生的，
     * 会复用对象，在这个区间外是直接在堆上分布的，
     */
    public static void integerCompare() {
        Integer big1 = 127;
        Integer big2 = 127;


        Integer small1 = 44;
        Integer small2 = 44;

        System.out.println(big1 == big2);
        System.out.println(small1 == small2);
    }


    public static void main(String[] args) {
        atomicStampedReference();
        integerCompare();
    }
}
