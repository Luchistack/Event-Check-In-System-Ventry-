package org.EventCheckIn.notificationService.datas.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notification {
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
    private String metadata;
}
