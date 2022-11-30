package com.edu.icesi.virtualshop.mapper;

import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.dto.UserDTO;
import com.edu.icesi.virtualshop.model.User;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDTO(UserDTO userDTO);
    UserDTO fromUser(User user);
    UserCreateDTO fromUserWithPassword(User user);
    User fromDTO(UserCreateDTO userCreateDTO);
    default String fromUUID(UUID uuid) {
        return uuid.toString();
    }
    default UUID fromUUID(String uuid) {
        return UUID.fromString(uuid);
    }
}