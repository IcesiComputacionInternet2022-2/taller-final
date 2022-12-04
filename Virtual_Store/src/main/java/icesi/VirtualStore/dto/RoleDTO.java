package icesi.VirtualStore.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RoleDTO {

    private String name;

    private String description;

    private List<PermissionDTO> rolePermissions;
}
