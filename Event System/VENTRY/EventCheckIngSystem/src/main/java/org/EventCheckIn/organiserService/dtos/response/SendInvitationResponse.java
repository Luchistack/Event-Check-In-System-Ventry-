package org.EventCheckIn.organiserService.dtos.response;

import lombok.Data;

@Data
public class SendInvitationResponse {
    private String eventId;
    private int invitationsSent;
    private String message;
}
