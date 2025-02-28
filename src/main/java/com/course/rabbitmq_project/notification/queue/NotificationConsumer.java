//package com.course.rabbitmq_project.notification;
//
//
//import lombok.RequiredArgsConstructor;
//import lombok.SneakyThrows;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@RequiredArgsConstructor
//@Component
//public class NotificationConsumer {
//    private final NotificationQueueConfig notificationQueueConfig;
//
//    // Use SpEL to reference the queue name dynamically
//    @SneakyThrows
//    @RabbitListener(queues = "#{@notificationQueueConfig.notificationQueue}")
//    @RabbitListener(queues = {notificationQueueConfig.getNotificationQueueName()})
//    // consumeMessageFromQueue
//    private void consume(String notification) {
//        Thread.sleep(10000); // Delay message processing by 10 seconds
//        log.info("Notification Received from queue : {} " , notification);
//        notificationQueueConfig.getNotificationQueueName()
//    }
//}
