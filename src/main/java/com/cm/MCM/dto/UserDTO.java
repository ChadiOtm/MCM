package com.cm.MCM.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String function;
    private String roleName;
    private String cityName;

}
