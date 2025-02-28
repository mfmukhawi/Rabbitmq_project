package com.course.rabbitmq_project.notification;

import com.course.rabbitmq_project.rabbitMq.RabbitMQProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/api/notification")
public class NotificationController {

  private final NotificationService notificationService;

    @PostMapping("/send")
    public void pushNotificationToQueue() {
        notificationService.sendNotificationToQueue("mohammed");
    }
}
