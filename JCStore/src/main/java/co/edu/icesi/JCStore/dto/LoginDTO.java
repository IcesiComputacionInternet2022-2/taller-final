package co.edu.icesi.JCStore.dto;

import lombok.Data;


@Data
public class LoginDTO {


    private String email;

    //@Length(min = 10, max = 20)
    //@Pattern(regexp = "[A-Z]+[a-z]+[0-9]+[#$%@]+", message = "La contraseña debe tener:\n - Una mayuscula" +"\n - Una minuscula\n - Un numero\n - Un caracter como #$%@")
    private String password;
}
