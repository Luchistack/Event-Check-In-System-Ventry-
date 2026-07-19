package org.EventCheckIn.guestServices.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.EventCheckIn.guestServices.dtos.request.CreateGuestRequest;
import org.EventCheckIn.guestServices.dtos.response.GuestResponse;
import org.EventCheckIn.guestServices.datas.models.enums.GuestStatus;
import org.EventCheckIn.guestServices.services.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class GuestControllerTest {

    private MockMvc mockMvc;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private GuestService guestService;

    @InjectMocks
    private GuestController guestController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
    }

    @Test
    void createGuest_shouldReturnCreatedGuest() throws Exception {
        CreateGuestRequest request = new CreateGuestRequest();
        request.setFirstName("Jane");
        request.setLastName("Smith");
        request.setEmail("jane.smith@example.com");
        request.setPhone("+1987654321");
        request.setEventId("event-001");

        GuestResponse response = new GuestResponse();
        response.setId("guest-1");
        response.setFirstName("Jane");
        response.setLastName("Smith");
        response.setEmail("jane.smith@example.com");
        response.setPhone("+1987654321");
        response.setEventId("event-001");
        response.setStatus(GuestStatus.INVITED);
        response.setInvitationCode("inv-code");
        response.setQrCode("qr-code");
        response.setCreatedAt(LocalDateTime.now());
        response.setUpdatedAt(LocalDateTime.now());

        when(guestService.createGuest(any(CreateGuestRequest.class))).thenReturn(response);

        mockMvc.perform(post("/api/guests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("guest-1"))
                .andExpect(jsonPath("$.email").value("jane.smith@example.com"));
    }

    @Test
    void getGuest_shouldReturnGuestResponse() throws Exception {
        GuestResponse response = new GuestResponse();
        response.setId("guest-2");
        response.setFirstName("Sam");
        response.setLastName("Taylor");
        response.setEmail("sam.taylor@example.com");
        response.setEventId("event-002");
        response.setStatus(GuestStatus.CONFIRMED);

        when(guestService.getGuestById("guest-2")).thenReturn(response);

        mockMvc.perform(get("/api/guests/guest-2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("guest-2"))
                .andExpect(jsonPath("$.status").value("CONFIRMED"));
    }
}
