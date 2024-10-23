package com.cm.MCM.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")

public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cityId;

    @Column(unique = true)
    private String name;

    @Column(length = 1000)
    private String description;

    private String imageUrl;
}