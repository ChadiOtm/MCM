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
@Table(name = "\"user\"")
@NoArgsConstructor
@AllArgsConstructor

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID userId;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String phone;
    private String function;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
