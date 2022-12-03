package com.edu.icesi.MusicShop.controller;

import com.edu.icesi.MusicShop.api.UserAPI;
import com.edu.icesi.MusicShop.dto.UserCreateDTO;
import com.edu.icesi.MusicShop.dto.UserDTO;
import com.edu.icesi.MusicShop.mapper.UserMapper;
import com.edu.icesi.MusicShop.service.UserService;
import lombok.AllArgsConstructor;
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
    public UserDTO getUser(UUID userId) {
        return userMapper.fromUser(userService.getUser(userId));
    }

    @Override
    public UserDTO createUser(@Valid UserCreateDTO userDTO) {
        return userMapper.fromUser(userService.createUser(userMapper.fromDTO(userDTO), userDTO.getRoleId()));
    }

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers().stream().map(userMapper::fromUser).collect(Collectors.toList());
    }
}
