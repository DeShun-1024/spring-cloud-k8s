package com.cloud.k8s.springcloudk8s.message.rabbit.simplequeue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class SimpleReceiver2 {

//    @RabbitListener(queues = "one-queue")
    public void receiveDto2(SimpleMessage message) {
        log.info("{} 消费者2 消费消息:{}", LocalDateTime.now(), message);
    }

}
