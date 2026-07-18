package org.EventCheckIn.securityService.dtos.operations.request;

import lombok.Data;

import java.time.LocalDateTime;

    @Data
    public class SecuritySetProfileRequest {

        private String username;
        private String email;
        private String department;
        private String badgeNumber;
    }
