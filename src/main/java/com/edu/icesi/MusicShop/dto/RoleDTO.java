package com.edu.icesi.MusicShop.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDTO {

    private String name;

    private String description;

    private List<PermissionDTO> rolePermissions;

}
