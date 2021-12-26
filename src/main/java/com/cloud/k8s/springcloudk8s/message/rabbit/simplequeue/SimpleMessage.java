package com.cloud.k8s.springcloudk8s.message.rabbit.simplequeue;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SimpleMessage {
    private String name;
//    private LocalDateTime now;
}
