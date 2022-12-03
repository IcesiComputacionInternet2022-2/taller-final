package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.dto.UserDTO;
import co.edu.icesi.JCStore.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User createUser(@RequestBody User user, UUID roleId);

    List<User>getUsers();

    User getUser(@PathVariable UUID userId);

}
