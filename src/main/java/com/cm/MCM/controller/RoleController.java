package com.cm.MCM.controller;

import com.cm.MCM.dto.RoleDTO;
import com.cm.MCM.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {


    private RoleService roleService;

    @PostMapping
    public ResponseEntity<RoleDTO> addNewCity(@RequestBody RoleDTO roleDTO) {
        RoleDTO savedRole = roleService.addNewRole(roleDTO);
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }
}
