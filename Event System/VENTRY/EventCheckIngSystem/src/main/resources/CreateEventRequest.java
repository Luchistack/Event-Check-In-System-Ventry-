package main.java.org.EventCheckIn.organiserService.dtos.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CreateEventRequest {
    private String eventName;
    private String description;
    private String location;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer capacity;
    private String category;
    private String organizerId;
    private List<MultipartFile> eventMediaFiles;
    private MultipartFile bannerImage;
}
