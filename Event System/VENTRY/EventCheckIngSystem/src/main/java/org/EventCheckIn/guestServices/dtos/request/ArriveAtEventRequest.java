package org.EventCheckIn.guestServices.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArriveAtEventRequest {

    @NotBlank(message = "Guest ID is required")
    private String guestId;
}
