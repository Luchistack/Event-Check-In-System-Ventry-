package main.java.org.EventCheckIn.organiserService.dtos.request;



@Data
public class UploadGuestRequest {
    private String eventId;
    private String guestName;
    private String email;
    private String phoneNumber;
}
