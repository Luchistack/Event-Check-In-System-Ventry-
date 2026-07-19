package org.EventCheckIn.securityService.services;

import org.EventCheckIn.securityService.dtos.auth.request.SecurityLoginRequest;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityRegisterRequest;
import org.EventCheckIn.securityService.dtos.operations.request.ScanQRRequest;
import org.EventCheckIn.securityService.dtos.operations.request.SecuritySetProfileRequest;
import org.EventCheckIn.securityService.dtos.operations.request.VerifyGuestRequest;
import org.EventCheckIn.securityService.dtos.operations.response.ScanQRResponse;
import org.EventCheckIn.securityService.dtos.operations.response.SecuritySetProfileResponse;
import org.EventCheckIn.securityService.dtos.operations.response.VerifyGuestResponse;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityLoginResponse;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityRegisterResponse;
import org.EventCheckIn.securityService.dtos.request.UpdateSecurityProfileRequest;
import org.EventCheckIn.securityService.dtos.response.UpdateSecurityProfileResponse;

public interface SecurityProfileService {
    UpdateSecurityProfileResponse updateSecurityProfile(UpdateSecurityProfileRequest request);
    SecuritySetProfileResponse securityProfile(SecuritySetProfileRequest request);
    SecurityRegisterResponse registerSecurity(SecurityRegisterRequest request);
    SecurityLoginResponse securityLogin(SecurityLoginRequest request);
    ScanQRResponse scanQrCode(ScanQRRequest request);
    VerifyGuestResponse verifyGuest(VerifyGuestRequest request);
}
