package org.EventCheckIn.guestServices.services;

import lombok.RequiredArgsConstructor;
import org.EventCheckIn.guestServices.datas.models.Guest;
import org.EventCheckIn.guestServices.datas.models.enums.GuestStatus;
import org.EventCheckIn.guestServices.datas.repositories.GuestRepository;
import org.EventCheckIn.guestServices.dtos.request.ArriveAtEventRequest;
import org.EventCheckIn.guestServices.dtos.request.CreateGuestRequest;
import org.EventCheckIn.guestServices.dtos.request.EnterEventRequest;
import org.EventCheckIn.guestServices.dtos.request.OpenInvitationRequest;
import org.EventCheckIn.guestServices.dtos.request.QrCodeScannedRequest;
import org.EventCheckIn.guestServices.dtos.request.ReceiveInvitationRequest;
import org.EventCheckIn.guestServices.dtos.response.GuestResponse;
import org.EventCheckIn.guestServices.exceptions.GuestNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    @Override
    public GuestResponse createGuest(CreateGuestRequest request) {
        if (guestRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Guest already exists for email: " + request.getEmail());
        }

        Guest guest = new Guest();
        guest.setFirstName(request.getFirstName());
        guest.setLastName(request.getLastName());
        guest.setEmail(request.getEmail());
        guest.setPhone(request.getPhone());
        guest.setEventId(request.getEventId());
        guest.setInvitationCode(UUID.randomUUID().toString());
        guest.setQrCode(UUID.randomUUID().toString());
        guest.setStatus(GuestStatus.INVITED);
        guest.setInvitationOpened(false);
        guest.setInvitationReceived(false);
        guest.setEventEntered(false);
        guest.setCheckedIn(false);

        Guest saved = guestRepository.save(guest);
        return buildGuestResponse(saved);
    }

    @Override
    public GuestResponse getGuestById(String id) {
        return guestRepository.findById(id)
                .map(this::buildGuestResponse)
                .orElseThrow(() -> new GuestNotFoundException("id", id));
    }

    @Override
    public GuestResponse receiveInvitation(ReceiveInvitationRequest request) {
        Guest guest = guestRepository.findByInvitationCode(request.getInvitationCode())
                .orElseThrow(() -> new GuestNotFoundException("invitationCode", request.getInvitationCode()));
        guest.setInvitationReceived(true);
        guest.setStatus(GuestStatus.CONFIRMED);
        return buildGuestResponse(guestRepository.save(guest));
    }

    @Override
    public GuestResponse openInvitation(OpenInvitationRequest request) {
        Guest guest = guestRepository.findByInvitationCode(request.getInvitationCode())
                .orElseThrow(() -> new GuestNotFoundException("invitationCode", request.getInvitationCode()));
        guest.setInvitationOpened(true);
        return buildGuestResponse(guestRepository.save(guest));
    }

    @Override
    public GuestResponse enterEvent(EnterEventRequest request) {
        Guest guest = guestRepository.findById(request.getGuestId())
                .orElseThrow(() -> new GuestNotFoundException(request.getGuestId()));
        if (!StringUtils.hasText(guest.getEventId()) || !guest.getEventId().equals(request.getEventId())) {
            throw new IllegalArgumentException("Guest is not registered for this event");
        }
        guest.setEventEntered(true);
        return buildGuestResponse(guestRepository.save(guest));
    }

    @Override
    public GuestResponse scanQrCode(QrCodeScannedRequest request) {
        Guest guest = guestRepository.findByQrCode(request.getQrCode())
                .orElseThrow(() -> new GuestNotFoundException("qrCode", request.getQrCode()));
        return buildGuestResponse(guest);
    }

    @Override
    public GuestResponse arriveAtEvent(ArriveAtEventRequest request) {
        Guest guest = guestRepository.findById(request.getGuestId())
                .orElseThrow(() -> new GuestNotFoundException(request.getGuestId()));
        guest.setCheckedIn(true);
        guest.setStatus(GuestStatus.CHECKED_IN);
        return buildGuestResponse(guestRepository.save(guest));
    }

    private GuestResponse buildGuestResponse(Guest guest) {
        GuestResponse response = new GuestResponse();
        response.setId(guest.getId());
        response.setFirstName(guest.getFirstName());
        response.setLastName(guest.getLastName());
        response.setEmail(guest.getEmail());
        response.setPhone(guest.getPhone());
        response.setEventId(guest.getEventId());
        response.setInvitationCode(guest.getInvitationCode());
        response.setQrCode(guest.getQrCode());
        response.setStatus(guest.getStatus());
        response.setInvitationOpened(guest.isInvitationOpened());
        response.setInvitationReceived(guest.isInvitationReceived());
        response.setEventEntered(guest.isEventEntered());
        response.setCheckedIn(guest.isCheckedIn());
        response.setCreatedAt(guest.getCreatedAt());
        response.setUpdatedAt(guest.getUpdatedAt());
        return response;
    }
}