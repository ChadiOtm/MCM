package com.cm.MCM.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubCategoryDTO {

    private UUID subCategoryId;

    private String name;

    private String description;

    private String imageUrl;

    private String categoryName;
}