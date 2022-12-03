package com.edu.icesi.MusicShop.mapper;

import com.edu.icesi.MusicShop.dto.UserCreateDTO;
import com.edu.icesi.MusicShop.dto.UserDTO;
import com.edu.icesi.MusicShop.model.User;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDTO(UserDTO userDTO);

    UserDTO fromUser(User user);

    User fromDTO(UserCreateDTO userCreateDTO);

    default String fromUUID(UUID uuid) {
        return uuid.toString();
    }

    default UUID fromUUID(String uuid) {
        return UUID.fromString(uuid);
    }
}
