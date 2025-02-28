//package com.course.rabbitmq_project.notification;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.amqp.core.TopicExchange;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@ConfigurationProperties(prefix = "rabbitmq")
//@Data
//public class NotificationConfigPrefix {
//    private Exchanges exchanges;
//    private Queue queue;
//    private RoutingKeys routingKeys;
//
//    @Data
//    public static class Exchanges {
//        private String internal;
//
//        @Bean
//        public TopicExchange internalTopicExchange() {
//            return new TopicExchange(this.internal);
//        }
//    }
//
//    @Data
//    @AllArgsConstructor
//    public static class Queue {
//        private String notification;
//        @Bean
//        public Queue notificationQueue() {
//            return new Queue(this.notification);
//        }
//    }
//
//    @Data
//    public static class RoutingKeys {
//        private String internalNotification;
//    }
//
//}
