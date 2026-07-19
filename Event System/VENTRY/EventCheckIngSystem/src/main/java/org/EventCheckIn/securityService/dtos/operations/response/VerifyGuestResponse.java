package main.java.org.EventCheckIn.securityService.dtos.operations.response;

import lombok.Data;

@Data
public class VerifyGuestResponse {
    private boolean verified;
    private String statusMessage;
}