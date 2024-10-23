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


public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID claimId;

    @Column(nullable = false)
    private String title;

    private String description;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
