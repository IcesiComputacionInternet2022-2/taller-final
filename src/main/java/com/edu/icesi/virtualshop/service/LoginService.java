package com.edu.icesi.virtualshop.service;

import com.edu.icesi.virtualshop.dto.LoginDTO;
import com.edu.icesi.virtualshop.dto.TokenDTO;

public interface LoginService {

    TokenDTO login(LoginDTO loginDTO);

}
