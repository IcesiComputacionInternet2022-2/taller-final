package co.edu.icesi.JCStore.mapper;

import co.edu.icesi.JCStore.dto.CreateUserDTO;
import co.edu.icesi.JCStore.dto.UserDTO;
import co.edu.icesi.JCStore.model.User;
import org.mapstruct.Mapper;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDTO(UserDTO userDTO);
    User fromCreateDTO(CreateUserDTO userDTO);
    UserDTO fromUser(User user);

    default String fromUUID(UUID uuid){return uuid.toString();}

    default UUID fromUUID(String uuid){return UUID.fromString(uuid);}

}
