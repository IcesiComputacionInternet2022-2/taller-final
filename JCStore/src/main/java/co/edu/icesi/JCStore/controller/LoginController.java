package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.api.LoginAPI;
import co.edu.icesi.JCStore.dto.LoginDTO;
import co.edu.icesi.JCStore.dto.TokenDTO;

import co.edu.icesi.JCStore.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class LoginController implements LoginAPI {

    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO){return loginService.login(loginDTO);}
}
