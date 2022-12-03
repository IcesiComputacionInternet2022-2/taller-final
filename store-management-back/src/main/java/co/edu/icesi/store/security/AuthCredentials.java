package co.edu.icesi.store.security;

import lombok.Data;

@Data
public class AuthCredentials {
    public String email;
    public String password;
}
