package org.EventCheckIn.securityService.services;

import org.EventCheckIn.securityService.datas.models.Security;
import org.EventCheckIn.securityService.datas.repositories.SecurityRepository;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityLoginRequest;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityRegisterRequest;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityLoginResponse;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityRegisterResponse;
import org.EventCheckIn.securityService.dtos.operations.request.ScanQRRequest;
import org.EventCheckIn.securityService.dtos.operations.request.SecuritySetProfileRequest;
import org.EventCheckIn.securityService.dtos.operations.request.VerifyGuestRequest;
import org.EventCheckIn.securityService.dtos.operations.response.ScanQRResponse;
import org.EventCheckIn.securityService.dtos.operations.response.SecuritySetProfileResponse;
import org.EventCheckIn.securityService.dtos.operations.response.VerifyGuestResponse;
import org.EventCheckIn.securityService.dtos.request.UpdateSecurityProfileRequest;
import org.EventCheckIn.securityService.dtos.response.UpdateSecurityProfileResponse;
import org.EventCheckIn.securityService.exceptions.AccountDoesNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class SecurityProfileServiceImpl implements SecurityProfileService {

    private final SecurityRepository securityRepository;

    public SecurityProfileServiceImpl(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Override
    public UpdateSecurityProfileResponse updateSecurityProfile(UpdateSecurityProfileRequest request) {
        Security security = securityRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AccountDoesNotExistException("Account does not exist"));

        if (request.getFirstName() != null) security.setFirstName(request.getFirstName());
        if (request.getLastName() != null) security.setLastName(request.getLastName());
        if (request.getPhoneNumber() != null) security.setPhoneNumber(request.getPhoneNumber());
        if (request.getNewPassword() != null) security.setPassword(request.getNewPassword());
        if (request.getEmail() != null) security.setEmail(request.getEmail());
        security.setUpdatedAt(LocalDateTime.now());

        securityRepository.save(security);

        UpdateSecurityProfileResponse updateResponse = new UpdateSecurityProfileResponse();
        updateResponse.setUpdatedAt(LocalDateTime.now());
        updateResponse.setMessage("Profile updated successfully");
        return updateResponse;
    }

    @Override
    public SecuritySetProfileResponse securityProfile(SecuritySetProfileRequest request) {
        SecuritySetProfileResponse response = new SecuritySetProfileResponse();
        response.setUsername(request.getUsername());
        response.setEmail(request.getEmail());
        response.setDepartment(request.getDepartment());
        response.setBadgeNumber(request.getBadgeNumber());
        response.setMessage("Security profile created");
        return response;
    }

    @Override
    public SecurityRegisterResponse registerSecurity(SecurityRegisterRequest request) {
        Security security = new Security();
        security.setId(UUID.randomUUID().toString());
        security.setFirstName(request.getFirstName());
        security.setLastName(request.getLastName());
        security.setEmail(request.getEmail());
        security.setPhoneNumber(request.getPhoneNumber());
        security.setPassword(request.getCreatePassword());
        security.setCreatedAt(LocalDateTime.now());
        security.setUpdatedAt(LocalDateTime.now());

        securityRepository.save(security);

        return new SecurityRegisterResponse("Security user registered", true, LocalDateTime.now());
    }

    @Override
    public SecurityLoginResponse securityLogin(SecurityLoginRequest request) {
        Security security = securityRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AccountDoesNotExistException("Account does not exist"));

        if (!security.getPassword().equals(request.getPassword())) {
            return SecurityLoginResponse.builder()
                    .token(null)
                    .username(security.getEmail())
                    .role("SECURITY")
                    .build();
        }

        return SecurityLoginResponse.builder()
                .token(UUID.randomUUID().toString())
                .username(security.getEmail())
                .role("SECURITY")
                .build();
    }

    @Override
    public ScanQRResponse scanQrCode(ScanQRRequest request) {
        ScanQRResponse response = new ScanQRResponse();
        response.setVisitorName("Unknown Visitor");
        response.setAccessLevel("UNKNOWN");
        response.setStatus(null);
        response.setMessage("QR scan simulated");
        return response;
    }

    @Override
    public VerifyGuestResponse verifyGuest(VerifyGuestRequest request) {
        VerifyGuestResponse response = new VerifyGuestResponse();
        response.setVerified(true);
        response.setStatusMessage("Guest verified successfully");
        return response;
    }
}
