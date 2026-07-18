package org.EventCheckIn.securityService.dtos.auth.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecurityRegisterResponse {

    private String message;
    private boolean success;
    private LocalDateTime registeredAt;
}
