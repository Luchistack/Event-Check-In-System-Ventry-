package org.EventCheckIn.organiserService.dtos.response;

import lombok.Data;

@Data
public class UploadGuestResponse {
    private String eventId;
    private int guestsUploaded;
    private String message;
}
