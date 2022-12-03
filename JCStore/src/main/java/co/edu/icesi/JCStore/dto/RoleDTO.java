package co.edu.icesi.JCStore.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RoleDTO {

    private UUID roleId;

    private String roleName;

    private String description;

    private List<PermissionDTO> rolePermission;
}
