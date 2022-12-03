package com.edu.icesi.MusicShop.controller;

import com.edu.icesi.MusicShop.api.LoginAPI;
import com.edu.icesi.MusicShop.dto.LoginDTO;
import com.edu.icesi.MusicShop.dto.TokenDTO;
import com.edu.icesi.MusicShop.service.LoginService;
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
