package org.EventCheckIn.guestServices.datas.repositories;

import org.EventCheckIn.guestServices.datas.models.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, String> {
    Optional<Guest> findByEmail(String email);
    Optional<Guest> findByInvitationCode(String invitationCode);
    Optional<Guest> findByQrCode(String qrCode);
}
