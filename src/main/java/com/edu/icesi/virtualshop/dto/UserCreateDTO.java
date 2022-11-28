package com.edu.icesi.virtualshop.dto;

import com.edu.icesi.virtualshop.validation.CustomAnnotations;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@CustomAnnotations.EmailAndPhoneValidation
public class UserCreateDTO {
    private UUID id;

    @CustomAnnotations.EmailValidation
    private String email;
    @CustomAnnotations.PhoneValidation
    private String phoneNumber;
    @NotBlank
    @CustomAnnotations.PasswordValidation
    private String password;

    private String address;

    public String getPhone(){
        return password;
    }

    public String getEmail(){
        return email;
    }
}
