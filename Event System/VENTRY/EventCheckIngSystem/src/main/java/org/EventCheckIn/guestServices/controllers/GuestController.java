package org.EventCheckIn.guestServices.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.EventCheckIn.guestServices.dtos.request.ArriveAtEventRequest;
import org.EventCheckIn.guestServices.dtos.request.CreateGuestRequest;
import org.EventCheckIn.guestServices.dtos.request.EnterEventRequest;
import org.EventCheckIn.guestServices.dtos.request.OpenInvitationRequest;
import org.EventCheckIn.guestServices.dtos.request.QrCodeScannedRequest;
import org.EventCheckIn.guestServices.dtos.request.ReceiveInvitationRequest;
import org.EventCheckIn.guestServices.dtos.response.GuestResponse;
import org.EventCheckIn.guestServices.services.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @PostMapping
    public ResponseEntity<GuestResponse> createGuest(@Valid @RequestBody CreateGuestRequest request) {
        return ResponseEntity.ok(guestService.createGuest(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuestResponse> getGuest(@PathVariable String id) {
        return ResponseEntity.ok(guestService.getGuestById(id));
    }

    @PostMapping("/invitations/receive")
    public ResponseEntity<GuestResponse> receiveInvitation(@Valid @RequestBody ReceiveInvitationRequest request) {
        return ResponseEntity.ok(guestService.receiveInvitation(request));
    }

    @PostMapping("/invitations/open")
    public ResponseEntity<GuestResponse> openInvitation(@Valid @RequestBody OpenInvitationRequest request) {
        return ResponseEntity.ok(guestService.openInvitation(request));
    }

    @PostMapping("/enter")
    public ResponseEntity<GuestResponse> enterEvent(@Valid @RequestBody EnterEventRequest request) {
        return ResponseEntity.ok(guestService.enterEvent(request));
    }

    @PostMapping("/scan-qr")
    public ResponseEntity<GuestResponse> scanQrCode(@Valid @RequestBody QrCodeScannedRequest request) {
        return ResponseEntity.ok(guestService.scanQrCode(request));
    }

    @PostMapping("/arrive")
    public ResponseEntity<GuestResponse> arriveAtEvent(@Valid @RequestBody ArriveAtEventRequest request) {
        return ResponseEntity.ok(guestService.arriveAtEvent(request));
    }
}
