package org.EventCheckIn.securityService.services;

import org.EventCheckIn.securityService.datas.models.Security;
import org.EventCheckIn.securityService.datas.repositories.SecurityRepository;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityLoginRequest;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityRegisterRequest;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityLoginResponse;
import org.EventCheckIn.securityService.dtos.auth.response.SecurityRegisterResponse;
import org.EventCheckIn.securityService.exceptions.AccountAlreadyRegisteredException;
import org.EventCheckIn.securityService.exceptions.InvalidAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private SecurityRepository securityRepository;

    @Override
    public SecurityRegisterResponse registerSecurity(SecurityRegisterRequest request) {

        Security security = securityRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new AccountAlreadyRegisteredException("Account already exist"));
//        Security security = new Security();
        security.setFirstName(request.getFirstName());
        security.setLastName(request.getLastName());
        security.setEmail(request.getEmail());
        security.setPhoneNumber(request.getPhoneNumber());
        // Note: Ideally, use a PasswordEncoder here
        security.setPassword(request.getCreatePassword());
        security.setCreatedAt(LocalDateTime.now());

        securityRepository.save(security);

        return new SecurityRegisterResponse("Registration successful", true, LocalDateTime.now());
    }

    @Override
    public SecurityLoginResponse securityLogin(SecurityLoginRequest request) {
        Security security = securityRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidAccountException("Invalid credentials"));

        if (!security.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return SecurityLoginResponse.builder()
                .token("GENERATED_JWT_TOKEN")
                .username(security.getFirstName())
                .build();
    }

    @Override
    public void securityLogout(String securityId) {
        // Logic to invalidate token or clear session
    }
}