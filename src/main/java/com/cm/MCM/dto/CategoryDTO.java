package com.cm.MCM.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private UUID categoryId;

    private String name;

    private String description;

    private String imageUrl;

    private String cityName;
}
