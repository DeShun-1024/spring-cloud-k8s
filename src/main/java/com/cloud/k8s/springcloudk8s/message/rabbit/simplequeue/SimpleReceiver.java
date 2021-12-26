package com.cloud.k8s.springcloudk8s.message.rabbit.simplequeue;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * 多消费者 消费一个队列
 *
 * @author hudeshun
 * @since 2021/12/26 15:10
 */
@Slf4j
@Component
public class SimpleReceiver {

    @RabbitListener(queues = "one-queue", containerFactory = "simpleRabbitListenerContainerFactory")
    public void receiveDto1(SimpleMessage message, Channel channel, Message msg) throws IOException {
        log.info("{} 消费者1 消费消息:{}", LocalDateTime.now(), message);

        // 手动ACK
        final long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        channel.basicAck(deliveryTag, true);
    }

}
