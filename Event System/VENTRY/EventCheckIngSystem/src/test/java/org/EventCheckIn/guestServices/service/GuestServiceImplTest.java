package org.EventCheckIn.guestServices.service;

import org.EventCheckIn.guestServices.datas.models.Guest;
import org.EventCheckIn.guestServices.datas.models.enums.GuestStatus;
import org.EventCheckIn.guestServices.datas.repositories.GuestRepository;
import org.EventCheckIn.guestServices.dtos.request.CreateGuestRequest;
import org.EventCheckIn.guestServices.dtos.request.ReceiveInvitationRequest;
import org.EventCheckIn.guestServices.dtos.response.GuestResponse;
import org.EventCheckIn.guestServices.exceptions.GuestNotFoundException;
import org.EventCheckIn.guestServices.services.GuestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GuestServiceImplTest {

    @Mock
    private GuestRepository guestRepository;

    @InjectMocks
    private GuestServiceImpl guestService;

    private CreateGuestRequest createGuestRequest;

    @BeforeEach
    void setUp() {
        createGuestRequest = new CreateGuestRequest();
        createGuestRequest.setFirstName("John");
        createGuestRequest.setLastName("Doe");
        createGuestRequest.setEmail("john.doe@example.com");
        createGuestRequest.setPhone("+1234567890");
        createGuestRequest.setEventId("event-123");
    }

    @Test
    void createGuest_shouldSaveGuestAndReturnResponse() {
        when(guestRepository.findByEmail(createGuestRequest.getEmail())).thenReturn(Optional.empty());
        when(guestRepository.save(any(Guest.class))).thenAnswer(invocation -> invocation.getArgument(0));

        GuestResponse response = guestService.createGuest(createGuestRequest);

        assertNotNull(response.getId());
        assertEquals("John", response.getFirstName());
        assertEquals("Doe", response.getLastName());
        assertEquals("john.doe@example.com", response.getEmail());
        assertEquals("event-123", response.getEventId());
        assertEquals(GuestStatus.INVITED, response.getStatus());
        assertFalse(response.isInvitationOpened());
        assertFalse(response.isInvitationReceived());
        assertFalse(response.isEventEntered());
        assertFalse(response.isCheckedIn());
    }

    @Test
    void getGuestById_whenMissing_shouldThrowGuestNotFoundException() {
        when(guestRepository.findById("missing-id")).thenReturn(Optional.empty());

        assertThrows(GuestNotFoundException.class, () -> guestService.getGuestById("missing-id"));
    }

    @Test
    void receiveInvitation_shouldMarkGuestAsConfirmed() {
        Guest guest = new Guest();
        guest.setId("guest-1");
        guest.setInvitationCode("inv-123");
        guest.setStatus(GuestStatus.INVITED);
        guest.setInvitationReceived(false);

        when(guestRepository.findByInvitationCode("inv-123")).thenReturn(Optional.of(guest));
        when(guestRepository.save(any(Guest.class))).thenAnswer(invocation -> invocation.getArgument(0));

        GuestResponse response = guestService.receiveInvitation(new ReceiveInvitationRequest() {{ setInvitationCode("inv-123"); }});

        assertTrue(response.isInvitationReceived());
        assertEquals(GuestStatus.CONFIRMED, response.getStatus());
    }
}
