package org.glenchiridza.notification.rabbitmq;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.glenchiridza.notification.service.api.NotificationService;
import org.glenchiridza.restclients.util.NotificationRequest;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@AllArgsConstructor
public class NotificationConsumer {

    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("CONSUMED FROM QUEUE :: {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
