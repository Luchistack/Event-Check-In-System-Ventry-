package org.EventCheckIn.eventServices.datas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.EventCheckIn.eventServices.datas.models.enums.EventCategory;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String eventName;
    private String description;
    private BigDecimal price;
    private EventCategory eventCategory;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private LocalDateTime updatedAt;
    private List<MultipartFile> productMediaFiles;

}
