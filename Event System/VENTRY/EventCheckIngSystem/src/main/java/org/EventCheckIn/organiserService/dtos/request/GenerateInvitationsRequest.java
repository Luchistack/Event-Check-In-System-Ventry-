package org.EventCheckIn.organiserService.dtos.request;

import lombok.Data;

import java.util.List;

@Data
public class GenerateInvitationsRequest {
    private String eventId;
    private List<String> guestIds;
    private String messageTemplate;
}
