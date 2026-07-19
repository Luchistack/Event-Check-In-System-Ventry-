package org.EventCheckIn.securityService.dtos.operations.response;

import lombok.Data;
import org.EventCheckIn.guestServices.datas.models.Guest;
import org.EventCheckIn.securityService.datas.enums.ScanStatus;

@Data
public class ScanQRResponse {
    private String visitorName;
    private String accessLevel;
    private Guest guestId;
    private ScanStatus status; // e.g., "VALID", "INVALID", "EXPIRED"
    private String message;

}