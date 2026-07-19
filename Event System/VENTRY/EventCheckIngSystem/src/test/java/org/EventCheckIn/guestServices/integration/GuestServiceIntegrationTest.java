package org.EventCheckIn.guestServices.integration;

import org.EventCheckIn.Main;
import org.EventCheckIn.guestServices.datas.models.enums.GuestStatus;
import org.EventCheckIn.guestServices.dtos.request.CreateGuestRequest;
import org.EventCheckIn.guestServices.dtos.response.GuestResponse;
import org.EventCheckIn.guestServices.services.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest(classes = Main.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class GuestServiceIntegrationTest {

    @Container
    @SuppressWarnings({"deprecation", "resource"})
    static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:15-alpine"))
            .withDatabaseName("event_test_db")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void registerDatasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @Autowired
    private GuestService guestService;

    @Test
    void createGuest_shouldPersistGuestAndRetrieveIt() {
        CreateGuestRequest request = new CreateGuestRequest();
        request.setFirstName("Test");
        request.setLastName("Visitor");
        request.setEmail("test.visitor@example.com");
        request.setPhone("+1234567890");
        request.setEventId("event-1");

        GuestResponse created = guestService.createGuest(request);

        assertThat(created.getId()).isNotBlank();
        assertThat(created.getEmail()).isEqualTo("test.visitor@example.com");
        assertThat(created.getStatus()).isEqualTo(GuestStatus.INVITED);
        assertThat(created.getInvitationCode()).isNotBlank();
        assertThat(created.getQrCode()).isNotBlank();

        GuestResponse loaded = guestService.getGuestById(created.getId());

        assertThat(loaded).isNotNull();
        assertThat(loaded.getId()).isEqualTo(created.getId());
        assertThat(loaded.getEventId()).isEqualTo("event-1");
        assertThat(loaded.isInvitationReceived()).isFalse();
    }
}
