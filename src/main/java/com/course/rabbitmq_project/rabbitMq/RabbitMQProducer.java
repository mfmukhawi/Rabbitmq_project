package com.course.rabbitmq_project.rabbitMq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitMQProducer {

    private final AmqpTemplate amqpTemplate;

    /**
     * Publishes a message to a specified exchange with a routing key.
     *
     * @param payload    The message payload.
     * @param exchange   The exchange name.
     * @param routingKey The routing key.
     */
    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing message to exchange {} using routingKey {}. Payload {}", exchange, routingKey,payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published message to exchange {} using routingKey {}", exchange, routingKey);
    }



}
