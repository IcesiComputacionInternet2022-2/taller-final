package com.edu.icesi.virtualshop.controller;

import com.edu.icesi.virtualshop.api.UserAPI;
import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.dto.UserDTO;
import com.edu.icesi.virtualshop.mapper.UserMapper;
import com.edu.icesi.virtualshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class UserController implements UserAPI {

    public final UserService userService;
    public final UserMapper userMapper;

    @Override
    public UserCreateDTO getUser(UUID userId) {
        return userMapper.fromUserWithPassword(userService.getUser(userId));
    }

    @Override
    public UserCreateDTO createUser(@Valid UserCreateDTO userDTO) {
            return userMapper.fromUserWithPassword(userService.createUser(userMapper.fromDTO(userDTO)));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }

}
