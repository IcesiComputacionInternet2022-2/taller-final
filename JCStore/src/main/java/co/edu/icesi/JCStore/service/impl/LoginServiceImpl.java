package co.edu.icesi.JCStore.service.impl;

import co.edu.icesi.JCStore.constants.TokenTime;
import co.edu.icesi.JCStore.dto.LoginDTO;
import co.edu.icesi.JCStore.dto.TokenDTO;
import co.edu.icesi.JCStore.error.exception.UserDemoException;
import co.edu.icesi.JCStore.model.User;
import co.edu.icesi.JCStore.repository.UserRepository;
import co.edu.icesi.JCStore.service.LoginService;
import co.edu.icesi.JCStore.utils.JWTParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class LoginServiceImpl implements LoginService {

    public final UserRepository userRepository;

    @Override
    public TokenDTO login(LoginDTO loginDTO){
        User user = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user1 -> user1.getEmail().equalsIgnoreCase(loginDTO.getEmail()))
                .findFirst()
                .orElseThrow();
        if (user.getPassword().equals(loginDTO.getPassword())){
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", user.getId().toString());
            claims.put("roleId", user.getRole().getRoleId().toString());
            return new TokenDTO(JWTParser.createJWT(user.getId().toString(), user.getName(),user.getName(),claims, 20*TokenTime.ONE_MINUTE.getTime()));
        }
        throw new InvalidParameterException();
    }
}
