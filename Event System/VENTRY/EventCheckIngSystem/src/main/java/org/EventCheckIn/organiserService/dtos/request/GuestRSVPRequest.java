package org.EventCheckIn.organiserService.dtos.request;

import lombok.Data;

@Data
public class GuestRSVPRequest {
    private String eventId;
    private String guestId;
    private String rsvpStatus;
}
