package org.EventCheckIn.guestServices.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.EventCheckIn.guestServices.datas.models.enums.GuestStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class GuestResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String eventId;
    private String invitationCode;
    private String qrCode;
    private GuestStatus status;
    private boolean invitationOpened;
    private boolean invitationReceived;
    private boolean eventEntered;
    private boolean checkedIn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
