package com.edu.icesi.virtualshop.api;

import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
public interface UserAPI {

    @GetMapping("/{userId}")
    public UserCreateDTO getUser(@PathVariable UUID userId);

    @PostMapping()
    public UserCreateDTO createUser(@RequestBody UserCreateDTO userCreateDTO);

    @GetMapping
    public List<UserDTO> getUsers();

}
