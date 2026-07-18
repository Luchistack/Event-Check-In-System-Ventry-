package org.EventCheckIn.securityService.dtos.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UpdateSecurityProfileResponse {
    private String message;
    private LocalDateTime updatedAt;
}