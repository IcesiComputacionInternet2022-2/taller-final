package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.constants.CodesError;
import co.edu.icesi.JCStore.error.exception.UserDemoException;
import co.edu.icesi.JCStore.mapper.UserMapper;
import co.edu.icesi.JCStore.mapper.UserMapperImpl;
import co.edu.icesi.JCStore.model.Permission;
import co.edu.icesi.JCStore.model.Role;
import co.edu.icesi.JCStore.model.User;
import co.edu.icesi.JCStore.repository.RoleRepository;
import co.edu.icesi.JCStore.repository.UserRepository;
import co.edu.icesi.JCStore.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private UserMapper userMapper;
    private UserService userService;

    @BeforeEach
    public void init(){
        userRepository = mock(UserRepository.class);
        roleRepository = mock(RoleRepository.class);
        userService = new UserServiceImpl(userRepository,roleRepository);
        userMapper = new UserMapperImpl();
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
    public void createUserTest(){
        User user = scenary1();
        UUID roleId = user.getRole().getRoleId();

        when(roleRepository.findById(roleId)).thenReturn(Optional.ofNullable(user.getRole()));
        userService.createUser(user, roleId);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void verifySingleEmailTest(){
        User user = scenary1();

        when(userRepository.findUserByEmail(user.getEmail())).thenReturn(Optional.ofNullable(user));

        try{
            userService.createUser(user, user.getRole().getRoleId());
        }catch (UserDemoException e){
            assertEquals(e.getError().getCode(), CodesError.CODE_02.getCode());
        }
    }

    @Test
    public void verifySinglePhoneTest(){
        User user = scenary1();

        when(userRepository.findUserByPhone(user.getPhone())).thenReturn(Optional.ofNullable(user));

        try{
            userService.createUser(user, user.getRole().getRoleId());
        }catch (UserDemoException e){
            assertEquals(e.getError().getCode(), CodesError.CODE_03.getCode());
        }
    }

    @Test
    public void getUsersTest(){
        userService.getUsers();
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void getUserTest(){
        User user = scenary1();

        userService.getUser(user.getId());
        verify(userRepository, times(1)).findById(user.getId());
    }
}
