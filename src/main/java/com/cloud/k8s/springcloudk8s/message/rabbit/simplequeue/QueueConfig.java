package com.cloud.k8s.springcloudk8s.message.rabbit.simplequeue;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessagingMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean("one-queue")
    public Queue queue() {
        return new Queue("one-queue");
    }

}
