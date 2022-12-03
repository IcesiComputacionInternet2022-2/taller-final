package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.constants.TokenTime;
import co.edu.icesi.JCStore.dto.LoginDTO;
import co.edu.icesi.JCStore.model.Permission;
import co.edu.icesi.JCStore.model.Role;
import co.edu.icesi.JCStore.model.User;
import co.edu.icesi.JCStore.repository.UserRepository;
import co.edu.icesi.JCStore.service.impl.LoginServiceImpl;
import co.edu.icesi.JCStore.utils.JWTParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class LoginServiceTest {

    UserRepository userRepository;

    LoginService loginService;

    JWTParser jwtParser;

    @BeforeEach
    public void init(){
        userRepository = mock(UserRepository.class);
        loginService = new LoginServiceImpl(userRepository);
    }

    public User scenary1(){
        UUID uuidRole = UUID.randomUUID();
        UUID uuidUser = UUID.randomUUID();
        UUID uuidPermission = UUID.randomUUID();

        Permission permission = new Permission(uuidPermission, "/users","create.users","POST");
        List<Permission> permissions = new ArrayList<>();
        permissions.add(permission);

        Role role = new Role(uuidRole, "Buyer", "The buyer will be our main customer and will only have permissions to perform actions related to the purchase.",permissions);
        User user = new User(uuidUser,"Juan", "juancamilo@gmail.com", "juancamilo20*", "Cra 2da #49-68", "3107115055", role,null);

        return user;
     }
    @Test
    public void loginTest(){
        User user = scenary1();
        List<User> users = new ArrayList<>();

        users.add(user);
        when(userRepository.findAll()).thenReturn(users);

        try{
            LoginDTO loginDTO = new LoginDTO("juancamilo@gmail.com","juancamil20*");
            loginService.login(loginDTO);
        }catch (InvalidParameterException e){
            assertTrue(true);
        }
    }
}
