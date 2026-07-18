package org.EventCheckIn.securityService.services;

import org.EventCheckIn.securityService.datas.repositories.SecurityRepository;
import org.EventCheckIn.securityService.dtos.operations.request.ScanQRRequest;
import org.EventCheckIn.securityService.dtos.operations.request.VerifyGuestRequest;
import org.EventCheckIn.securityService.dtos.operations.response.ScanQRResponse;
import org.EventCheckIn.securityService.dtos.operations.response.VerifyGuestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityOperationsServiceImpl implements SecurityOperationsService{

    public SecurityOperationsServiceImpl(SecurityRepository securityRepository) {
        this.securityRepository = securityRepository;
    }

    @Autowired
    private SecurityRepository securityRepository;


    @Override
    public ScanQRResponse scanQrCode(ScanQRRequest request) {
        return null;
    }

    @Override
    public VerifyGuestResponse verifyGuest(VerifyGuestRequest request) {
        return null;
    }
}
