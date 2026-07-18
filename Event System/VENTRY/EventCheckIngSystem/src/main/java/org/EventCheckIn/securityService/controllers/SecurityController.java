package org.EventCheckIn.securityService.controllers;
import jakarta.validation.Valid;
import org.EventCheckIn.securityService.dtos.operations.request.ScanQRRequest;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityLoginRequest;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityRegisterRequest;
import org.EventCheckIn.securityService.dtos.operations.request.VerifyGuestRequest;
import org.EventCheckIn.securityService.services.SecurityProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/security")
public class SecurityController {

    @Autowired
    private final SecurityProfileService securityService;

    public SecurityController(SecurityProfileService securityService) {
        this.securityService = securityService;
    }

    @PostMapping("register")
    public ResponseEntity<?> registerSecurity(@Valid @RequestBody SecurityRegisterRequest request){
        return ResponseEntity.ok(securityService.registerSecurity(request));
    }

    @PostMapping("log-in")
    public ResponseEntity<?> loginSecurity(@Valid @RequestBody SecurityLoginRequest request){
        return ResponseEntity.ok(securityService.securityLogin(request));
    }

    @GetMapping("scan-code")
    public ResponseEntity<?> scanQrCode(@Valid @RequestBody ScanQRRequest request){
        return ResponseEntity.ok(SecurityProfileService.scanQrCode(request));
    }

    @GetMapping("verify")
    public ResponseEntity<?> verifyGuest(@Valid @RequestBody VerifyGuestRequest request){
        return ResponseEntity.ok(SecurityProfileService.verifyGuest(request));
    }
}
