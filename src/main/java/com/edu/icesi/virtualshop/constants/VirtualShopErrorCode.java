package com.edu.icesi.virtualshop.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum VirtualShopErrorCode {
    CODE_001("La contraseña debe tener al menos una letra mayuscula, una minuscula, un numero y un simbolo como #$%@"),
    CODE_002("Solo puedes consultar tu propia informacion"),
    CODE_003("Atributos irrepetibles ya estan presentes en el sistema"),
    CODE_004("No es un usuario valido"),
    CODE_005("Se debe tener al menos un telefono o un email registrado"),
    CODE_006("Formato invalido para el email"),
    CODE_007("El numero debe empezar por +57 y debe tener 10 digitos"),
    CODE_008("Informacion de acceso incorrecta");

    private String message;

    public String getMessage(){
        return message;
    }
}