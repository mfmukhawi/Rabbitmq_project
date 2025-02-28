package com.course.rabbitmq_project.rabbitMq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * RabbitMQ configuration for message publishing and consumption.
 */
@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    private final ConnectionFactory connectionFactory;

    /**
     * Configures the RabbitMQ template for sending messages.
     * Uses Jackson for JSON message conversion.
     *
     * @return AmqpTemplate for message publishing.
     */
    @Bean
    public AmqpTemplate amqpTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jacksonMessageConverter());
        return rabbitTemplate;
    }

    /**
     * Configures message conversion to JSON using Jackson.
     *
     * @return MessageConverter for JSON serialization.
     */
    @Bean
    public MessageConverter jacksonMessageConverter() {
        // here you can send object mapper
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Configures the RabbitMQ listener container for receiving messages.
     *
     * @return SimpleRabbitListenerContainerFactory with JSON message conversion.
     */
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory() {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(jacksonMessageConverter());
        return factory;
    }

}
