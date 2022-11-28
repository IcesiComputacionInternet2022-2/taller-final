package com.edu.icesi.virtualshop.api;

import com.edu.icesi.virtualshop.dto.LoginDTO;
import com.edu.icesi.virtualshop.dto.TokenDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public interface LoginAPI {
    @PostMapping
    TokenDTO login(@RequestBody LoginDTO loginDTO);
}
