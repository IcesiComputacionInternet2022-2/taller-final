package co.edu.icesi.store.service;

import co.edu.icesi.store.dto.LoginDTO;
import co.edu.icesi.store.dto.TokenDTO;
import co.edu.icesi.store.model.Role;
import co.edu.icesi.store.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    TokenDTO login(LoginDTO loginDTO);

    User register(@RequestBody User user, UUID roleId);
    User edit(@RequestBody User user, UUID roleId);

    List<User> getUsers();

    List<Role> getRoles();
}