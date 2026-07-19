package org.EventCheckIn.guestServices.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrCodeScannedRequest {

    @NotBlank(message = "QR code is required")
    private String qrCode;
}
