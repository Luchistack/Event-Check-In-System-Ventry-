package org.EventCheckIn.guestServices.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnterEventRequest {

    @NotBlank(message = "Guest ID is required")
    private String guestId;

    @NotBlank(message = "Event ID is required")
    private String eventId;
}
