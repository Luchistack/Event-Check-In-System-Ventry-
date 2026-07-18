package org.EventCheckIn.securityService.datas.repositories;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.EventCheckIn.securityService.datas.models.Security;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepository extends JpaRepository<Security, String> {
    Optional<Security> findByEmail(String email);
}
