package com.edu.icesi.MusicShop.service.impl;

import com.edu.icesi.MusicShop.dto.LoginDTO;
import com.edu.icesi.MusicShop.dto.TokenDTO;
import com.edu.icesi.MusicShop.model.User;
import com.edu.icesi.MusicShop.repository.UserRepository;
import com.edu.icesi.MusicShop.service.LoginService;
import com.edu.icesi.MusicShop.utils.JWTParser;
import io.jsonwebtoken.Claims;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
@Primary
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO) {

        User user = StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .filter(user1 -> user1.getEmail().equals(loginDTO.getEmail()))
                .findFirst()
                .orElseThrow();
        if(user.getPassword().equals(loginDTO.getPassword())) {
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getId().toString(),user.getFirstName(), user.getFirstName(), claims,100000L));
        }
        throw new InvalidParameterException();
    }

}
