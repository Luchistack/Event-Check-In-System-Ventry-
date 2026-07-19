package org.EventCheckIn.guestServices.services;

import org.EventCheckIn.guestServices.dtos.request.ArriveAtEventRequest;
import org.EventCheckIn.guestServices.dtos.request.CreateGuestRequest;
import org.EventCheckIn.guestServices.dtos.request.EnterEventRequest;
import org.EventCheckIn.guestServices.dtos.request.OpenInvitationRequest;
import org.EventCheckIn.guestServices.dtos.request.QrCodeScannedRequest;
import org.EventCheckIn.guestServices.dtos.request.ReceiveInvitationRequest;
import org.EventCheckIn.guestServices.dtos.response.GuestResponse;

public interface GuestService {
    GuestResponse createGuest(CreateGuestRequest request);
    GuestResponse getGuestById(String id);
    GuestResponse receiveInvitation(ReceiveInvitationRequest request);
    GuestResponse openInvitation(OpenInvitationRequest request);
    GuestResponse enterEvent(EnterEventRequest request);
    GuestResponse scanQrCode(QrCodeScannedRequest request);
    GuestResponse arriveAtEvent(ArriveAtEventRequest request);
}
