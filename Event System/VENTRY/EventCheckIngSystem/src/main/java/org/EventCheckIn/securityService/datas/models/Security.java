package org.EventCheckIn.securityService.datas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component

@Entity
@Data
public class Security {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String PhoneNumber;
    private int age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String password;
}
