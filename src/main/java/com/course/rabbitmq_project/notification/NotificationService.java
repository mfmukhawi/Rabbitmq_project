package com.course.rabbitmq_project.notification;

import com.course.rabbitmq_project.rabbitMq.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class NotificationService {

    private final NotificationQueueConfig notificationQueueConfig;
    private final RabbitMQProducer producer;

    //- Notification Producer
    public void sendNotificationToQueue(Notification message) {
        producer.publish(
                message,
                notificationQueueConfig.getNotificationExchange(),
                notificationQueueConfig.getNotificationRoutingKey()
        );
    }

    //- Notification Consumer
    @SneakyThrows
    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    private void consumeNotificationFromQueue(Notification notification) {
        Thread.sleep(10000); // Delay message processing by 10 seconds
        log.info("Notification Received from queue : {} " , notification);
        // save in database
    }
}
