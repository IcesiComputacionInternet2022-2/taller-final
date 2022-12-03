package co.edu.icesi.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UUID userId;

    private String userName;

    private String email;

    private String address;

    private String phoneNumber;

    private RoleDTO role;
}
