package com.cloud.k8s.springcloudk8s.spring.hystrix;


import rx.Observable;
import rx.functions.Action1;

public class MyRxDemo {

    public static void helloWorld(String... names) {
        final Observable<String> from = Observable.from(names);
        from.subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                System.out.println("hello" + s);
            }
        });
    }

    public static void create() {


    }

    public static void main(String[] args) {
        helloWorld("hudeshun");
    }
}
