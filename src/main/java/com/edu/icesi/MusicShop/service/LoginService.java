package com.edu.icesi.MusicShop.service;

import com.edu.icesi.MusicShop.dto.LoginDTO;
import com.edu.icesi.MusicShop.dto.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginDTO loginDTO);

}
