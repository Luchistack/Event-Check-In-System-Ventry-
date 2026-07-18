package org.EventCheckIn.eventServices.services;

import lombok.AllArgsConstructor;
import org.EventCheckIn.eventServices.datas.models.Events;
import org.EventCheckIn.eventServices.dtos.request.AddEventRequest;
import org.EventCheckIn.eventServices.dtos.request.CancelEventRequest;
import org.EventCheckIn.eventServices.dtos.request.CheckInRequest;
import org.EventCheckIn.eventServices.dtos.request.UpdateEventRequest;
import org.EventCheckIn.eventServices.dtos.response.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventService extends JpaRepository<Events, String> {

    AddEventResponse addEvent(AddEventRequest request);
    CancelEventResponse cancelEvent(CancelEventRequest request);
    UpdateEventResponse updateEvent(UpdateEventRequest request);

//    Retrieval
    Events getEvent(String eventId);
    List<Events> findAllEvents();
//Check in
    CheckInResponse checkIn(CheckInRequest request);
    List<AttendanceResponse> getCheckedInAttendance(String id);
}

//@AllArgsConstructor - the field most have final, that determines the argumentconstructor you want
