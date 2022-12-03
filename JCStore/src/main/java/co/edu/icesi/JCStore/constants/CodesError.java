package co.edu.icesi.JCStore.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CodesError {

    CODE_01("CODE_01", "The user must contain a phone number or an email address to be registered."),
    CODE_02("CODE_02", "Repeated user, the email you have entered is already registered."),
    CODE_03("CODE_03", "Repeated user, the phone number you have entered is already registered."),
    CODE_04("401","Unahuthorized: error debe estar autenticado para realizar el request"),
    CODE_05("CODE_05", "non-existent role"),
    CODE_06("CODE_06", "You are not authorized to make this request");

    private String code;
    private String message;
}
