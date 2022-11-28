package com.edu.icesi.virtualshop.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public interface UserAPI {

    @GetMapping("/{userId}")
    public UserCreateDTO getUser(@PathVariable UUID userId);

    @PostMapping()
    public UserCreateDTO createUser(@RequestBody UserCreateDTO userCreateDTO);

    @GetMapping
    public List<UserDTO> getUsers();

}
