package com.edu.icesi.virtualshop.service.impl;

import com.edu.icesi.virtualshop.constants.VirtualShopErrorCode;
import com.edu.icesi.virtualshop.dto.LoginDTO;
import com.edu.icesi.virtualshop.dto.TokenDTO;
import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.edu.icesi.virtualshop.error.exception.VirtualShopException;
import com.edu.icesi.virtualshop.model.User;
import com.edu.icesi.virtualshop.repository.UserRepository;
import com.edu.icesi.virtualshop.service.LoginService;
import com.edu.icesi.virtualshop.utils.JWTParser;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .filter(user1 -> user1.getLoginAttribute().equals(loginDTO.getLoginAttribute()))
                .findFirst()
                .orElseThrow();
        if(user.getPassword().equals(loginDTO.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getUserId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getUserId().toString(), claims,100000L));
        }
        throw new VirtualShopException(HttpStatus.UNAUTHORIZED, new VirtualShopError(VirtualShopErrorCode.CODE_008.toString(), VirtualShopErrorCode.CODE_008.getMessage()));

    }

}