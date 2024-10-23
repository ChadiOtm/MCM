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

public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID categoryId;
    private String name;
    private String description;
    private String imageUrl;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
