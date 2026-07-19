package org.EventCheckIn.eventServices.services;

import lombok.RequiredArgsConstructor;
import org.EventCheckIn.eventServices.datas.models.Events;
import org.EventCheckIn.eventServices.datas.repositories.EventRepository;
import org.EventCheckIn.eventServices.dtos.request.AddEventRequest;
import org.EventCheckIn.eventServices.dtos.request.CancelEventRequest;
import org.EventCheckIn.eventServices.dtos.request.CheckInRequest;
import org.EventCheckIn.eventServices.dtos.request.UpdateEventRequest;
import org.EventCheckIn.eventServices.dtos.response.AddEventResponse;
import org.EventCheckIn.eventServices.dtos.response.AttendanceResponse;
import org.EventCheckIn.eventServices.dtos.response.CancelEventResponse;
import org.EventCheckIn.eventServices.dtos.response.CheckInResponse;
import org.EventCheckIn.eventServices.dtos.response.UpdateEventResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public AddEventResponse addEvent(AddEventRequest request) {
        Events event = new Events();
        event.setEventName(request.getEventName());
        event.setDescription(request.getDescription());
        event.setPrice(request.getPrice());
        event.setEventCategory(request.getEventCategory());
        event.setProductMediaFiles(request.getEventMediaFiles());

        Events saved = eventRepository.save(event);

        AddEventResponse response = new AddEventResponse();
        response.setEventName(saved.getEventName());
        response.setDescription(saved.getDescription());
        response.setPrice(saved.getPrice());
        response.setEventCategory(saved.getEventCategory());
        response.setEventMediaFiles(saved.getProductMediaFiles());
        return response;
    }

    @Override
    public CancelEventResponse cancelEvent(CancelEventRequest request) {
        CancelEventResponse response = new CancelEventResponse();
        return response;
    }

    @Override
    public UpdateEventResponse updateEvent(UpdateEventRequest request) {
        UpdateEventResponse response = new UpdateEventResponse();
        return response;
    }

    @Override
    public Events getEvent(String eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public List<Events> findAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public CheckInResponse checkIn(CheckInRequest request) {
        return new CheckInResponse();
    }

    @Override
    public List<AttendanceResponse> getCheckedInAttendance(String eventId) {
        return Collections.emptyList();
    }
}
