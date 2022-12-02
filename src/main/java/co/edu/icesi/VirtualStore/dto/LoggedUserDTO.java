package co.edu.icesi.VirtualStore.dto;

import co.edu.icesi.VirtualStore.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LoggedUserDTO {

    private UUID id;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private Role role;

    private CartDTO cart;

}