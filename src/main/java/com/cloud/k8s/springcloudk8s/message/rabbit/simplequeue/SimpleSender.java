package com.cloud.k8s.springcloudk8s.message.rabbit.simplequeue;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class SimpleSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    @Qualifier("one-queue")
    private Queue queue;

//    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void sendString() {
        String message = "hello world";

        System.out.println(LocalDateTime.now() + "send..");

        rabbitTemplate.convertAndSend(queue.getName(), message);
    }

//    @Scheduled(fixedDelay = 50, initialDelay = 10)
    public void sendDto1() {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("spring");
        log.info("{},send-1 队列{},send {}", LocalDateTime.now(), "one-queue", simpleMessage);
        rabbitTemplate.convertAndSend(queue.getName(), simpleMessage);
    }

//    @Scheduled(fixedDelay = 50, initialDelay = 10)
    public void sendDto2() {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("spring");
        log.info("{},send-2 队列{},send {}", LocalDateTime.now(), "one-queue", simpleMessage);
        rabbitTemplate.convertAndSend(queue.getName(), simpleMessage);
    }

//    @Scheduled(fixedDelay = 500, initialDelay = 100)
    public void sendDto3() {
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setName("spring");
        log.info("{},send-3 队列{},send {}", LocalDateTime.now(), "one-queue", simpleMessage);
        rabbitTemplate.convertAndSend(queue.getName(), simpleMessage);
    }


}
