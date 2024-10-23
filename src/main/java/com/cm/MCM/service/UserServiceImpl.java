package com.cm.MCM.service;


import com.cm.MCM.dto.UserDTO;
import com.cm.MCM.mapper.UserMapper;
import com.cm.MCM.model.City;
import com.cm.MCM.model.Role;
import com.cm.MCM.model.User;
import com.cm.MCM.repository.CityRepository;
import com.cm.MCM.repository.RoleRepository;
import com.cm.MCM.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;
    private RoleRepository roleRepository;
    private CityRepository cityRepository;


    @Override
    @Transactional
    public UserDTO addNewUser(UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        User user = userMapper.UserDTOtoUser(userDTO);

        // Fetch existing Role by name
        if (userDTO.getRoleName() != null) {
            Role role = roleRepository.findByName(userDTO.getRoleName())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found: " + userDTO.getRoleName()));
            user.setRole(role);
        }

        // Fetch existing City by name
        if (userDTO.getCityName() != null) {
            City city = cityRepository.findByName(userDTO.getCityName())
                    .orElseThrow(() -> new EntityNotFoundException("City not found: " + userDTO.getCityName()));
            user.setCity(city);
        }

        User savedUser = userRepository.save(user);
        return userMapper.UsertoUserDTO(savedUser);
    }


    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.UserListToUserLstDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findUserById(UUID userID) {
        return userMapper.UsertoUserDTO(userRepository.findById(userID).orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userID)));
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        if (userDTO == null || userDTO.getUserId() == null) {
            throw new IllegalArgumentException("User and User ID cannot be null");
        }

        // First check if the user exists
        User existingUser = userRepository.findById(userDTO.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userDTO.getUserId()));

        // Update the existing user with new values
        User userToUpdate = userMapper.UserDTOtoUser(userDTO);

        // Handle Role update if provided
        if (userDTO.getRoleName() != null) {
            Role role = roleRepository.findByName(userDTO.getRoleName())
                    .orElseThrow(() -> new EntityNotFoundException("Role not found: " + userDTO.getRoleName()));
            userToUpdate.setRole(role);
        } else {
            userToUpdate.setRole(existingUser.getRole());  // Preserve existing role if not provided
        }

        // Handle City update if provided
        if (userDTO.getCityName() != null) {
            City city = cityRepository.findByName(userDTO.getCityName())
                    .orElseThrow(() -> new EntityNotFoundException("City not found: " + userDTO.getCityName()));
            userToUpdate.setCity(city);
        } else {
            userToUpdate.setCity(existingUser.getCity());  // Preserve existing city if not provided
        }

        // Save the updated user
        User savedUser = userRepository.save(userToUpdate);
        return userMapper.UsertoUserDTO(savedUser);
    }

    @Override
    public void deleteUser(UUID userID) {
        userRepository.deleteById(userID);
    }
}
