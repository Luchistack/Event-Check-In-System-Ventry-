package org.EventCheckIn.guestServices.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OpenInvitationRequest {

    @NotBlank(message = "Invitation code is required")
    private String invitationCode;
}
