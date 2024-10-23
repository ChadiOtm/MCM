package com.cm.MCM.controller;


import com.cm.MCM.dto.UserDTO;
import com.cm.MCM.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> addNewCity(@RequestBody UserDTO userDTO) {
        UserDTO savedUser = userService.addNewUser(userDTO);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> listOfUSers = userService.getAllUsers();
        return new ResponseEntity<>(listOfUSers , HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable UUID userId){
        UserDTO user = userService.findUserById(userId);
        return new ResponseEntity<>(user , HttpStatus.OK);
    }


    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable UUID userId,
            @RequestBody UserDTO userDTO) {
        userDTO.setUserId(userId); //ensure we are updating the user we want
        UserDTO updatedUser = userService.updateUser(userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
