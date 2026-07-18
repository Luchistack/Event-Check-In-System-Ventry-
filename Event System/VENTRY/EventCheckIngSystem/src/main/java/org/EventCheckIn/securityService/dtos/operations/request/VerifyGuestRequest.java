package org.EventCheckIn.securityService.dtos.operations.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VerifyGuestRequest {
    @NotBlank(message = "Guest token is required")
    private String guestToken;

    @NotBlank(message = "Verification code is required")
    private String verificationCode;
}
