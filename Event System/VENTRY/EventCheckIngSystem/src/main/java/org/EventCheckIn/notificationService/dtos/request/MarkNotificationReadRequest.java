package org.EventCheckIn.notificationService.dtos.request;

import lombok.Data;

@Data
public class MarkNotificationReadRequest {
    private String notificationId;
    private String recipientId;
}
