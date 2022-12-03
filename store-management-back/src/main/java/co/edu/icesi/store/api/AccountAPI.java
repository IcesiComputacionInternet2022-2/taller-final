package co.edu.icesi.store.api;

import co.edu.icesi.store.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/account")
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", allowCredentials = "true")
public interface AccountAPI {

    @PostMapping("/login")
    TokenDTO login(@RequestBody LoginDTO loginDTO);

    @PostMapping("/register")
    UserDTO register(@RequestBody UserCreateDTO user);

    @PostMapping("/edit")
    UserDTO edit(@RequestBody UserEditDTO user);

    @GetMapping
    List<UserDTO> getUsers();

    @GetMapping("/roles")
    List<RoleDTO> getRoles();
}