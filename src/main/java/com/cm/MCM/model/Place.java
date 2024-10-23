package com.cm.MCM.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID placeId;
    private String name;
    private String description;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    private SubCategory subCategory;
}
