package com.cloud.k8s.springcloudk8s.rx;

import org.springframework.retry.annotation.Retryable;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

public class RxJavaHelloWrold {


    public static void test_1() {
        // Hello World
        Observable.create(subscriber -> {
            subscriber.onNext("Hello World!");
            subscriber.onCompleted();
        }).subscribe(System.out::println);

        // shorten by using helper method
        Observable.just("Hello", "World!")
                .subscribe(System.out::println);

        // add onError and onComplete listeners
        Observable.just("Hello World!")
                .subscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done"));
    }

    public static void test_2() {
        // expand to show full classes
        Observable.create(new OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello World!");

                System.out.println(1/0);
                subscriber.onCompleted();
            }

        }).subscribe(new Subscriber<String>() {

            @Override
            public void onCompleted() {
                System.out.println("Done");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("错误");
                e.printStackTrace();
            }

            @Override
            public void onNext(String t) {
                System.out.println("下一个");
                System.out.println(t);
            }
        });
    }

    public static void main(String[] args) {
        test_2();
    }
}
