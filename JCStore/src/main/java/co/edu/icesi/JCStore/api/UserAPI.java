package co.edu.icesi.JCStore.api;

import co.edu.icesi.JCStore.dto.CreateUserDTO;
import co.edu.icesi.JCStore.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RequestMapping("/users")
public interface UserAPI {

    @PostMapping()
    UserDTO createUser(@RequestBody CreateUserDTO createUserDTO);

    @GetMapping()
    List<UserDTO> getUsers();

    @GetMapping("/{userId}")
    UserDTO getUser(@PathVariable UUID userId);
}
