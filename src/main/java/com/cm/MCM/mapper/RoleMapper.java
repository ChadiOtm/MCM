package com.cm.MCM.mapper;


import com.cm.MCM.dto.RoleDTO;
import com.cm.MCM.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDTO RoleToRoleDTO(Role role);
    Role RoleDTOtoRole(RoleDTO roleDTO);
}
