package org.EventCheckIn.securityService.dtos.operations.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ScanQRRequest {
    @NotBlank(message = "QR Code data cannot be empty")
    private String qrCodeData;

    @NotNull(message = "Latitude is required")
    private Double latitude;

    @NotNull(message = "Longitude is required")
    private Double longitude;
}