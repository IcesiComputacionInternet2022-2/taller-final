package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.api.UserAPI;
import co.edu.icesi.JCStore.config.InitialDataConfig;
import co.edu.icesi.JCStore.constants.CodesError;
import co.edu.icesi.JCStore.dto.CreateUserDTO;
import co.edu.icesi.JCStore.dto.UserDTO;
import co.edu.icesi.JCStore.error.exception.UserDemoError;
import co.edu.icesi.JCStore.error.exception.UserDemoException;
import co.edu.icesi.JCStore.mapper.UserMapper;
import co.edu.icesi.JCStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Import({InitialDataConfig.class})
public class UserController implements UserAPI {

    UserService userService;

    UserMapper userMapper;

    @Override
    public UserDTO createUser(CreateUserDTO createUserDTO) {
        verifyEmailOrPhone(createUserDTO);

        return userMapper.fromUser(userService.createUser(userMapper.fromCreateDTO(createUserDTO), createUserDTO.getRoleId()));
    }

    private void verifyEmailOrPhone(CreateUserDTO createUserDTO){
        if(createUserDTO.getEmail() == null && createUserDTO.getPhone() == null){
            throw new UserDemoException(HttpStatus.BAD_REQUEST,
                    new UserDemoError(CodesError.CODE_01.getCode(),CodesError.CODE_01.getMessage()));
        }
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUser(userService.getUser(userId));
    }

}
