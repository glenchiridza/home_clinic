package org.glenchiridza.notification.service.impl;

import lombok.AllArgsConstructor;
import org.glenchiridza.notification.model.Notification;
import org.glenchiridza.notification.repository.NotificationRepository;
import org.glenchiridza.notification.service.api.NotificationService;
import org.glenchiridza.restclients.util.NotificationRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    @Override
    public void send(NotificationRequest notificationRequest) {

        notificationRepository.save(
          Notification.builder()
                  .toPatientId(notificationRequest.toPatientId())
                  .toPatientEmail(notificationRequest.toPatientEmail())
                  .sender("glenchiridza@gmail.com")
                  .message(notificationRequest.message())
                  .sentAt(LocalDateTime.now())
                  .build()
        );

    }
}
