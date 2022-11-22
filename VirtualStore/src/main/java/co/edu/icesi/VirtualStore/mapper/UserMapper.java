package co.edu.icesi.VirtualStore.mapper;

import co.edu.icesi.VirtualStore.dto.UserDTO;
import co.edu.icesi.VirtualStore.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User fromDTO(UserDTO userDTO);
    UserDTO fromTatabro(User user);
}