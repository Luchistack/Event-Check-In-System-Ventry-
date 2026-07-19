package main.java.org.EventCheckIn.organiserService.data.models;

import lombok.Data;

@Data
public class OrganizerMonitorsDashboard {
    private String organizerId;
    private int totalEvents;
    private int totalGuests;
    private int totalInvitationsSent;
    private int totalCheckIns;
}
