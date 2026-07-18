package org.EventCheckIn.securityService.services;


import org.EventCheckIn.securityService.datas.models.Security;
import org.EventCheckIn.securityService.datas.repositories.SecurityRepository;
import org.EventCheckIn.securityService.dtos.operations.request.SecuritySetProfileRequest;
import org.EventCheckIn.securityService.dtos.operations.response.SecuritySetProfileResponse;
import org.EventCheckIn.securityService.dtos.request.UpdateSecurityProfileRequest;
import org.EventCheckIn.securityService.dtos.response.UpdateSecurityProfileResponse;
import org.EventCheckIn.securityService.exceptions.AccountDoesNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        if(request.getEmail() != null)  security.setEmail(request.getEmail());
        security.setUpdatedAt(request.getUpdatedAt());

        securityRepository.save(security);

        UpdateSecurityProfileResponse updateResponse = new UpdateSecurityProfileResponse();
        updateResponse.setUpdatedAt(LocalDateTime.now());
        updateResponse.setMessage("Profile updated successfully");

        return updateResponse;

    }

    @Override
    public SecuritySetProfileResponse securityProfile(SecuritySetProfileRequest request) {

        return null;
    }
}
