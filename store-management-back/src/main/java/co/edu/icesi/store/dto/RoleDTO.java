package co.edu.icesi.store.dto;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RoleDTO {

    private UUID roleId;

    private String roleName;

    private String roleDescription;

    private List<PermissionDTO> rolePermissions;
}
