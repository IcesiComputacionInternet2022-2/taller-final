package co.edu.icesi.VirtualStore.dto;

import co.edu.icesi.VirtualStore.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class LoggedUserDTO {

    private UUID id;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private Role role;

}
