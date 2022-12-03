package co.edu.icesi.store.dto;

import lombok.Data;

@Data
public class PermissionDTO {


    private String uri;

    private String permissionKey;

    private String permissionMethod;
}