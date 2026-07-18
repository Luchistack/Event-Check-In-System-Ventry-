package org.EventCheckIn.securityService.dtos.operations.response;

import lombok.Data;

@Data
public class SecuritySetProfileResponse {
    private String username;
    private String email;
    private String department;
    private String badgeNumber;
    private String message;
}