package co.edu.icesi.VirtualStore.controller;

import co.edu.icesi.VirtualStore.api.LoginAPI;
import co.edu.icesi.VirtualStore.dto.LoginDTO;
import co.edu.icesi.VirtualStore.dto.TokenDTO;
import co.edu.icesi.VirtualStore.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class LoginController implements LoginAPI {

    private final LoginService loginService;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}