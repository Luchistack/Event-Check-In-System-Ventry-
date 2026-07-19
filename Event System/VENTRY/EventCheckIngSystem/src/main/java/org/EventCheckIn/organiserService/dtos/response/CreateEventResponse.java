package org.EventCheckIn.organiserService.dtos.response;

import lombok.Data;

import java.util.List;

@Data
public class CreateEventResponse {
    private String eventId;
    private String eventName;
    private String status;
    private String message;
    private List<String> eventImageUrls;
    private String bannerImageUrl;
}
