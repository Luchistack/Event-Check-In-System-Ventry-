package org.EventCheckIn.organiserService.dtos.response;

import lombok.Data;

@Data
public class GenerateInvitationsResponse {
    private String eventId;
    private int invitationsCreated;
    private String message;
}
