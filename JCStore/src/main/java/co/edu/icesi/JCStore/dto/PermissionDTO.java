package co.edu.icesi.JCStore.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PermissionDTO {

    private UUID permissionId;

    private String uri;

    private String permissioKey;

    private String method;
}
