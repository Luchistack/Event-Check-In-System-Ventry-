package org.EventCheckIn.organiserService.dtos.response;

import lombok.Data;

@Data
public class GuestRSVPResponse {
    private String guestId;
    private String eventId;
    private String rsvpStatus;
    private String message;
}
