package org.EventCheckIn.organiserService.services;

import org.EventCheckIn.organiserService.dtos.request.CreateEventRequest;
import org.EventCheckIn.organiserService.dtos.request.GenerateInvitationsRequest;
import org.EventCheckIn.organiserService.dtos.request.GuestRSVPRequest;
import org.EventCheckIn.organiserService.dtos.request.SendInvitationRequest;
import org.EventCheckIn.organiserService.dtos.request.UploadGuestRequest;
import org.EventCheckIn.organiserService.dtos.response.CreateEventResponse;
import org.EventCheckIn.organiserService.dtos.response.GenerateInvitationsResponse;
import org.EventCheckIn.organiserService.dtos.response.GuestRSVPResponse;
import org.EventCheckIn.organiserService.dtos.response.SendInvitationResponse;
import org.EventCheckIn.organiserService.dtos.response.UploadGuestResponse;
import org.EventCheckIn.organiserService.dtos.response.OrganizerResponse;

public interface OrganiserService {

    CreateEventResponse createEvent(CreateEventRequest request);

    GenerateInvitationsResponse generateInvitations(GenerateInvitationsRequest request);

    GuestRSVPResponse guestRsvp(GuestRSVPRequest request);

    SendInvitationResponse sendInvitation(SendInvitationRequest request);

    UploadGuestResponse uploadGuest(UploadGuestRequest request);

    OrganizerResponse getOrganizerById(String organizerId);
}
