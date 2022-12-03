package com.edu.icesi.MusicShop.mapper;

import com.edu.icesi.MusicShop.dto.RoleDTO;
import com.edu.icesi.MusicShop.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    Role fromDTO(RoleDTO roleDTO);

    RoleDTO fromRole(Role role);

}
