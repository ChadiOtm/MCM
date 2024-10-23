package com.cm.MCM.mapper;

import com.cm.MCM.dto.UserDTO;
import com.cm.MCM.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roleName", source = "role.name")
    @Mapping(target = "cityName", source = "city.name")
    UserDTO UsertoUserDTO(User user);

    @Mapping(target = "city", ignore = true)
    @Mapping(target = "role", ignore = true)
    User UserDTOtoUser(UserDTO userDTO);

    @Mapping(target = "roleName", source = "role.name")
    @Mapping(target = "cityName", source = "city.name")
    List<UserDTO> UserListToUserLstDTO(List<User> users);

    @Mapping(target = "city", ignore = true)
    @Mapping(target = "role", ignore = true)
    List<User> UserDTOListToUserList(List<UserDTO> userDTOs);
}