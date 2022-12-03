package co.edu.icesi.store.mapper;

import co.edu.icesi.store.dto.RoleDTO;
import co.edu.icesi.store.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDTO(RoleDTO roleDTO);

    RoleDTO fromRole(Role role);
}
