package com.edu.icesi.MusicShop.api;

import com.edu.icesi.MusicShop.dto.UserCreateDTO;
import com.edu.icesi.MusicShop.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.UUID;

@RequestMapping("/rest/user")
public interface UserAPI {

    @GetMapping("/{userId}")
    public UserDTO getUser(@PathVariable UUID userId);

    @PostMapping()
    public UserDTO createUser(@RequestBody UserCreateDTO userDTO);

    @GetMapping
    public List<UserDTO> getUsers();

}
