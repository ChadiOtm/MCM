package com.cm.MCM.mapper;

import com.cm.MCM.dto.UserDTO;
import com.cm.MCM.model.City;
import com.cm.MCM.model.Role;
import com.cm.MCM.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T12:28:25+0100",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO UsertoUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setRoleName( userRoleName( user ) );
        userDTO.setCityName( userCityName( user ) );
        userDTO.setUserId( user.getUserId() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setFunction( user.getFunction() );

        return userDTO;
    }

    @Override
    public User UserDTOtoUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userDTO.getUserId() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setEmail( userDTO.getEmail() );
        user.setPhone( userDTO.getPhone() );
        user.setFunction( userDTO.getFunction() );

        return user;
    }

    @Override
    public List<UserDTO> UserListToUserLstDTO(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( UsertoUserDTO( user ) );
        }

        return list;
    }

    @Override
    public List<User> UserDTOListToUserList(List<UserDTO> userDTOs) {
        if ( userDTOs == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOs.size() );
        for ( UserDTO userDTO : userDTOs ) {
            list.add( UserDTOtoUser( userDTO ) );
        }

        return list;
    }

    private String userRoleName(User user) {
        if ( user == null ) {
            return null;
        }
        Role role = user.getRole();
        if ( role == null ) {
            return null;
        }
        String name = role.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String userCityName(User user) {
        if ( user == null ) {
            return null;
        }
        City city = user.getCity();
        if ( city == null ) {
            return null;
        }
        String name = city.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
