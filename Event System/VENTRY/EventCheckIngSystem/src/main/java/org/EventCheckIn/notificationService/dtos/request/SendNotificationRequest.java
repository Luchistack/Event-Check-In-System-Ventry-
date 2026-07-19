package org.EventCheckIn.notificationService.dtos.request;

import lombok.Data;

import java.util.Map;

@Data
public class SendNotificationRequest {
    private String recipientId;
    private String senderId;
    private String eventId;
    private String organizerId;
    private String title;
    private String message;
    private String notificationType;
    private String channel;
    private String redirectUrl;
    private Map<String, String> metadata;
}
