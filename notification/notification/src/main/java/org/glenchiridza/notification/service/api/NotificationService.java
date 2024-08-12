package org.glenchiridza.notification.service.api;

import org.glenchiridza.restclients.util.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest notificationRequest);
}
