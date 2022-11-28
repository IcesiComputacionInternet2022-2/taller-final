package com.edu.icesi.virtualshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private UUID userId;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;
}
