package co.edu.icesi.JCStore.controller;


import co.edu.icesi.JCStore.constants.CodesError;
import co.edu.icesi.JCStore.dto.CreateUserDTO;
import co.edu.icesi.JCStore.error.exception.UserDemoException;
import co.edu.icesi.JCStore.mapper.UserMapper;
import co.edu.icesi.JCStore.mapper.UserMapperImpl;
import co.edu.icesi.JCStore.model.Role;
import co.edu.icesi.JCStore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserControllerTest {

    private UserService userService;
    private UserMapper userMapper;
    private UserController userController;

    @BeforeEach
    public void init() {
        userService = mock(UserService.class);
        userMapper = new UserMapperImpl();
        userController = new UserController(userService, userMapper);
    }

    @Test
    public void testCreateUser(){
        UUID uuidUser = UUID.randomUUID();
        UUID uuidRole = UUID.randomUUID();
        CreateUserDTO createUserDTO = new CreateUserDTO(uuidUser, "Juan", "juancamilo@gmail.com", "juancamilo20*", "Cra 2da #49-68", "3107115055", uuidRole);

        userController.createUser(createUserDTO);
        verify(userService, times(1)).createUser(userMapper.fromCreateDTO(createUserDTO), createUserDTO.getRoleId());
    }

    @Test
    public void verifyEmailOrPhoneTest(){
        UUID uuidUser = UUID.randomUUID();
        UUID uuidRole = UUID.randomUUID();
        CreateUserDTO createUserDTO = new CreateUserDTO(uuidUser, "Juan", null, "juancamilo20*", "Cra 2da #49-68", null, uuidRole);

        try{
            userController.createUser(createUserDTO);
        }catch (UserDemoException e){
            assertEquals(CodesError.CODE_01.getCode(), e.getError().getCode());
        }
    }

    @Test
    public void getUsersTest(){
        userController.getUsers();
        verify(userService, times(1)).getUsers();
    }

    @Test
    public void getUserTest(){
        UUID uuid = UUID.randomUUID();

        userController.getUser(uuid);
        verify(userService, times(1)).getUser(uuid);
    }

}
