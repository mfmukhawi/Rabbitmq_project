package com.course.rabbitmq_project.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationQueueConfig {

    @Value("${rabbitmq.exchanges.notification}")
    private String notificationExchange;

    @Value("${rabbitmq.queues.notification}")
    private String notificationQueueName;

    @Value("${rabbitmq.routing-keys.notification}")
    private String notificationRoutingKey;

    // 1- Create Topic Exchange
    @Bean
    public TopicExchange notificationTopicExchange() {
        return new TopicExchange(notificationExchange);
    }

    // 2- Create Notification Queue
    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueueName);
    }
    // 3- Create Binding
    @Bean
    public Binding notificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(notificationTopicExchange())
                .with(notificationRoutingKey);
    }

}
