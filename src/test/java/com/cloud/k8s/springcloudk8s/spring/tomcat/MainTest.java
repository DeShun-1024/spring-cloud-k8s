package com.cloud.k8s.springcloudk8s.spring.tomcat;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class MainTest {


    private static void concurrentTest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("http:localhost:30000/test")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
    }

    public static void main(String[] args) throws IOException {


            for (int i = 0; i < 50; i++) {
                new Thread(() -> {
                    try {
                        concurrentTest();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }


}
