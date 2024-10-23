package com.cm.MCM.service;


import com.cm.MCM.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public UserDTO addNewUser(UserDTO userDTO);

    public List<UserDTO> getAllUsers();

    public UserDTO findUserById(UUID userID);

    public UserDTO updateUser(UserDTO userDTO);

    public void deleteUser(UUID userID);
}
