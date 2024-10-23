package com.cm.MCM.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class CityDTO {
    private UUID cityId;
    private String name;
    private String description;
    private String imageUrl;
}