package org.EventCheckIn.guestServices.datas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.EventCheckIn.guestServices.datas.models.enums.GuestStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private String phone;
    private String eventId;

    @Column(unique = true)
    private String invitationCode;

    @Column(unique = true)
    private String qrCode;
    private boolean invitationOpened;
    private boolean invitationReceived;
    private boolean eventEntered;
    private boolean checkedIn;

    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
