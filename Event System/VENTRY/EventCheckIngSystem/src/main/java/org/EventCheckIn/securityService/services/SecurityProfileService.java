package org.EventCheckIn.securityService.services;
import jakarta.validation.Valid;
import org.EventCheckIn.securityService.dtos.auth.request.SecurityRegisterRequest;
import org.EventCheckIn.securityService.dtos.operations.request.SecuritySetProfileRequest;
import org.EventCheckIn.securityService.dtos.operations.response.SecuritySetProfileResponse;
import org.EventCheckIn.securityService.dtos.request.UpdateSecurityProfileRequest;
import org.EventCheckIn.securityService.dtos.response.UpdateSecurityProfileResponse;

public interface SecurityProfileService {
 //   Aaccount/Profile Management
    UpdateSecurityProfileResponse updateSecurityProfile(UpdateSecurityProfileRequest request);
    SecuritySetProfileResponse securityProfile(SecuritySetProfileRequest request);


//    UpdateSecurityPasswordResponse updateSecurityPassword(UpdateSecurityPasswordRequest request);
//    ForgotPasswordResponse forgotSecurityPassword(UpdateSecurityPasswordRequest request);
//    ResetPasswordResponse resetSecurityPassword(ResetSecurityPasswordRequest request);
//// /Session/AccessControl
//    UpdateSecurityStatusResponse updateSecurityStatus(UpdateSecurityStatusRequest request);
//    GetShiftReportResponse getShiftReport(GetShiftReportRequest request);
//    LogSecurityIncidentResponse incidentReport(LogSecurityIncidentRequest request);
//


}
