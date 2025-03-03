package com.course.rabbitmq_project.notification;

import com.course.rabbitmq_project.rabbitMq.RabbitMQProducer;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send")
    public void pushNotificationToQueue() {
        Faker faker = new Faker();

        Notification notification = Notification.builder()
                .id(faker.random().nextLong())
                .title(faker.name().title())
                .message(faker.book().genre())
                .build();

        notificationService.sendNotificationToQueue(notification);
    }
}
