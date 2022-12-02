package com.edu.icesi.virtualshop.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email;
    private String phoneNumber;
    private String password;

    public String getLoginAttribute(){
        if(email!=null){
            return email;
        }
        else{
            return phoneNumber;
        }
    }
}
