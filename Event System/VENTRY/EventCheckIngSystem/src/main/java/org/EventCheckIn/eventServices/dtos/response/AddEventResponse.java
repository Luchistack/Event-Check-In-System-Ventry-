package org.EventCheckIn.eventServices.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.EventCheckIn.eventServices.datas.models.enums.EventCategory;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class AddEventResponse {

    private String eventName;
    private String description;
    private BigDecimal price;
    private EventCategory eventCategory;
    private List<MultipartFile> EventMediaFiles;
}
