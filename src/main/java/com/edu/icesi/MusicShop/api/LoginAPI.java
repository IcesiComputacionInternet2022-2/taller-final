package com.edu.icesi.MusicShop.api;

import com.edu.icesi.MusicShop.dto.LoginDTO;
import com.edu.icesi.MusicShop.dto.TokenDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rest/login")
public interface LoginAPI {

    @PostMapping
    TokenDTO login(@RequestBody LoginDTO loginDTO);

}
