package org.EventCheckIn.eventServices.datas.repositories;

import org.EventCheckIn.eventServices.datas.models.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Events, String> {
}
