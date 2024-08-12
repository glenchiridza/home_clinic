package org.glenchiridza.restclients.notifications;


import org.glenchiridza.restclients.util.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "notification",path = "api/notifications")
public interface NotificationClient {

    @PostMapping
    void sendNotification(NotificationRequest notificationRequest);
}
