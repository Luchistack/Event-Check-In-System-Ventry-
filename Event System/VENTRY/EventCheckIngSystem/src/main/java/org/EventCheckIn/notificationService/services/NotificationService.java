package org.EventCheckIn.notificationService.services;

import org.EventCheckIn.notificationService.dtos.request.MarkNotificationReadRequest;
import org.EventCheckIn.notificationService.dtos.request.SendNotificationRequest;
import org.EventCheckIn.notificationService.dtos.response.NotificationResponse;
import org.EventCheckIn.notificationService.dtos.response.SendNotificationResponse;

import java.util.List;

public interface NotificationService {
    SendNotificationResponse sendNotification(SendNotificationRequest request);

    NotificationResponse getNotificationById(String notificationId);

    NotificationResponse markNotificationAsRead(MarkNotificationReadRequest request);

    List<NotificationResponse> listNotificationsForRecipient(String recipientId);
}
