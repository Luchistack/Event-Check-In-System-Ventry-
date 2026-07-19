package org.EventCheckIn.eventServices.services;

import org.EventCheckIn.eventServices.datas.models.Events;
import org.EventCheckIn.eventServices.dtos.request.AddEventRequest;
import org.EventCheckIn.eventServices.dtos.request.CancelEventRequest;
import org.EventCheckIn.eventServices.dtos.request.CheckInRequest;
import org.EventCheckIn.eventServices.dtos.request.UpdateEventRequest;
import org.EventCheckIn.eventServices.dtos.response.AddEventResponse;
import org.EventCheckIn.eventServices.dtos.response.AttendanceResponse;
import org.EventCheckIn.eventServices.dtos.response.CancelEventResponse;
import org.EventCheckIn.eventServices.dtos.response.CheckInResponse;
import org.EventCheckIn.eventServices.dtos.response.UpdateEventResponse;

import java.util.List;

public interface EventService {

    AddEventResponse addEvent(AddEventRequest request);
    CancelEventResponse cancelEvent(CancelEventRequest request);
    UpdateEventResponse updateEvent(UpdateEventRequest request);

    Events getEvent(String eventId);
    List<Events> findAllEvents();

    CheckInResponse checkIn(CheckInRequest request);
    List<AttendanceResponse> getCheckedInAttendance(String eventId);
}
