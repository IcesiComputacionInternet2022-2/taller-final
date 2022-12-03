package co.edu.icesi.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEditDTO {

    private UUID userId;

    private String userName;

    private String email;

    private String address;

    private String phoneNumber;

    private UUID roleId;
}