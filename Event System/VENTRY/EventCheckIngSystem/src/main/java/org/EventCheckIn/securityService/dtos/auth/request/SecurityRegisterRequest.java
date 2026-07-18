package org.EventCheckIn.securityService.dtos.auth.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecurityRegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String createPassword;
    private LocalDateTime createdAt;
}
