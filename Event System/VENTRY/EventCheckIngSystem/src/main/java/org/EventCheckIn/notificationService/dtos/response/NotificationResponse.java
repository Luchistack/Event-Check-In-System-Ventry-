package org.EventCheckIn.notificationService.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class NotificationResponse {
    private String notificationId;
    private String recipientId;
    private String senderId;
    private String eventId;
    private String organizerId;
    private String title;
    private String message;
    private String notificationType;
    private String channel;
    private String redirectUrl;
    private boolean read;
    private String status;
    private LocalDateTime sentAt;
    private LocalDateTime readAt;
    private Map<String, String> metadata;
}
