package org.glenchiridza.notification.controller;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.glenchiridza.notification.service.api.NotificationService;
import org.glenchiridza.restclients.util.NotificationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/notifications")
@AllArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.send(notificationRequest);
        log.info("Notification has been send to Patient email :: {}", notificationRequest.toPatientEmail());
    }
}
