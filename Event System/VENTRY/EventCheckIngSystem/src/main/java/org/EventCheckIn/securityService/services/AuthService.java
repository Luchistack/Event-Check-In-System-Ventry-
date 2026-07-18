package org.EventCheckIn.securityService.services;

import org.EventCheckIn.securityService.dtos.auth.request.SecurityLoginRequest;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityRegisterRequest;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityLoginResponse;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityRegisterResponse;

public interface AuthService {
    SecurityRegisterResponse registerSecurity(SecurityRegisterRequest request) ;
    SecurityLoginResponse securityLogin(SecurityLoginRequest request);
    void securityLogout(String securityId);


}
