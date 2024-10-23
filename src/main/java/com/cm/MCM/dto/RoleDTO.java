package com.cm.MCM.dto;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public class RoleDTO {

    @Id
    private UUID roleId;
    private String name;
    private String description;
}
