package co.edu.icesi.store.mapper;

import co.edu.icesi.store.dto.UserCreateDTO;
import co.edu.icesi.store.dto.UserDTO;
import co.edu.icesi.store.dto.UserEditDTO;
import co.edu.icesi.store.model.User;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDTO(UserDTO userDTO);

    UserDTO fromUser(User user);

    User fromDTO(UserCreateDTO userCreateDTO);

    User fromDTO(UserEditDTO userCreateDTO);

    default String fromUUID(UUID uuid) {
        return uuid.toString();
    }

    default UUID fromUUID(String uuid) {
        return UUID.fromString(uuid);
    }
}