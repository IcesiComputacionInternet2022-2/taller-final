package com.edu.icesi.virtualshop.dto;

import com.edu.icesi.virtualshop.validation.CustomAnnotations;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@CustomAnnotations.EmailAndPhoneValidation
public class UserCreateDTO {

    private UUID user_id;
    @CustomAnnotations.EmailValidation
    private String email;

    @NotBlank
    @CustomAnnotations.PasswordValidation
    private String password;

    private String address;
    @CustomAnnotations.PhoneValidation
    private String phoneNumber;

    public String getPhone(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }
}
