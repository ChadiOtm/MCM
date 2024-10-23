package com.cm.MCM.mapper;

import com.cm.MCM.dto.RoleDTO;
import com.cm.MCM.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:37:27+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO RoleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        roleDTO.setRoleId( role.getRoleId() );
        roleDTO.setName( role.getName() );
        roleDTO.setDescription( role.getDescription() );

        return roleDTO;
    }

    @Override
    public Role RoleDTOtoRole(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Role role = new Role();

        role.setRoleId( roleDTO.getRoleId() );
        role.setName( roleDTO.getName() );
        role.setDescription( roleDTO.getDescription() );

        return role;
    }
}
