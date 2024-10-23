package com.cm.MCM.service;


import com.cm.MCM.dto.RoleDTO;
import com.cm.MCM.mapper.RoleMapper;
import com.cm.MCM.model.Role;
import com.cm.MCM.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    private RoleMapper roleMapper;


    @Override
    @Transactional
    public RoleDTO addNewRole(RoleDTO roleDTO) {
        if (roleDTO == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }

        Role role = roleMapper.RoleDTOtoRole(roleDTO);
        Role savedRole = roleRepository.save(role);
        return roleMapper.RoleToRoleDTO(savedRole);
    }

}
