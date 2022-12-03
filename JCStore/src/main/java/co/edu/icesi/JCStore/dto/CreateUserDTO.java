package co.edu.icesi.JCStore.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {

    private UUID id;

    @NotNull
    private String name;

    private String email;

    @NotNull
    private String password;

    private String address;

    private String phone;

    @NotNull
    private UUID roleId;

}
