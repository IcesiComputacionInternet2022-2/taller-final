package com.edu.icesi.virtualshop.controller;

import com.edu.icesi.virtualshop.api.LoginAPI;
import com.edu.icesi.virtualshop.dto.LoginDTO;
import com.edu.icesi.virtualshop.dto.TokenDTO;
import com.edu.icesi.virtualshop.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class LoginController implements LoginAPI {


    private final LoginService loginService;

    @Override
    public TokenDTO login(@Valid LoginDTO loginDTO) {
        return loginService.login(loginDTO);
    }
}
