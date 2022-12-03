package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.dto.LoginDTO;
import co.edu.icesi.JCStore.dto.TokenDTO;

public interface LoginService {
    TokenDTO login(LoginDTO loginDTO);
}
