package co.edu.icesi.JCStore.dto;

import co.edu.icesi.JCStore.model.Role;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID id;

    @NotNull
    private String name;

    private String email;

    private String password;

    private String address;

    private String phone;

    private Role role;

}
