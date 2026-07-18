package org.EventCheckIn.securityService.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;


@Data
    public class UpdateSecurityProfileRequest {
        @NotBlank(message = "Full name cannot be blank")
        private String lastName;

        @NotBlank(message = "Full name cannot be blank")
        private String firstName;

        @NotBlank(message = "Email cannot be emthy")
        private String email;

        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
        private String phoneNumber;

        private String newPassword; // Optional: include @Size validation if preferred

        private LocalDateTime updatedAt;

  }

