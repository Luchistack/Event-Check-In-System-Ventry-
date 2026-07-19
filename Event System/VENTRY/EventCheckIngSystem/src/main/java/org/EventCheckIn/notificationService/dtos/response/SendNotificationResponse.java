package org.EventCheckIn.notificationService.dtos.response;

import lombok.Data;

@Data
public class SendNotificationResponse {
    private String notificationId;
    private String status;
    private String message;
}
