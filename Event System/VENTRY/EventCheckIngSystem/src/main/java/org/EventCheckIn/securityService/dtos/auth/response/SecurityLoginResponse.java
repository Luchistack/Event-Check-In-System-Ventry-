package org.EventCheckIn.securityService.dtos.auth.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecurityLoginResponse {
    private String token;
    private String username;
    private String role;
}
