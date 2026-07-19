package main.java.org.EventCheckIn.organiserService.data.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Organizer {
    private String organizerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String organizationName;
    private String role;
    private String profileImageUrl;
    private List<String> eventImageUrls;
    private String bannerImageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
