package org.EventCheckIn.securityService.services;

import org.EventCheckIn.securityService.datas.models.Security;
import org.EventCheckIn.securityService.dtos.operations.request.ScanQRRequest;
import org.EventCheckIn.securityService.dtos.operations.request.VerifyGuestRequest;
import org.EventCheckIn.securityService.dtos.operations.response.ScanQRResponse;
import org.EventCheckIn.securityService.dtos.operations.response.VerifyGuestResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityOperationsService {
    ScanQRResponse scanQrCode(ScanQRRequest request);
    VerifyGuestResponse verifyGuest(VerifyGuestRequest request);

}
