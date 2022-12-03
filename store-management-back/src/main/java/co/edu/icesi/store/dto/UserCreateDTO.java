package co.edu.icesi.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO {

    private String userName;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private UUID roleId;
}