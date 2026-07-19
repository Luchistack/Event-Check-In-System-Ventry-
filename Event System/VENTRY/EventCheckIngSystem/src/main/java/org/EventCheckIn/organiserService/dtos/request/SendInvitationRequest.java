package org.EventCheckIn.organiserService.dtos.request;

import lombok.Data;

@Data
public class SendInvitationRequest {
    private String eventId;
    private String guestId;
    private String email;
    private String message;
}
