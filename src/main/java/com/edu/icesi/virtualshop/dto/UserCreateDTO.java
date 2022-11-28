package com.edu.icesi.virtualshop.dto;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class UserCreateDTO {
    private UUID id;

    private String email;
    private String phoneNumber;

    @NotBlank
    @PasswordValidation
    private String password;

    private String address;
}
