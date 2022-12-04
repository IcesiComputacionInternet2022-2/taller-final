package icesi.VirtualStore.controllerUnitTest;


import icesi.VirtualStore.controller.UserController;
import icesi.VirtualStore.dto.RoleDTO;
import icesi.VirtualStore.dto.UserCreateDTO;
import icesi.VirtualStore.dto.UserDTO;
import icesi.VirtualStore.mapper.UserMapper;
import icesi.VirtualStore.mapper.UserMapperImpl;
import icesi.VirtualStore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserControllerUnitTest {


    @Mock
    private UserService userService;


    private UserMapper userMapper;


    private UserController userController;


    @BeforeEach
    public void init(){
        userMapper = new UserMapperImpl();
        userController = new UserController(userService, userMapper);
    }


    /*
     * 1 create user
     * 2 get User
     * 3 get Users
     */

    @Test
    public void testCreateClientUser(){
        UserCreateDTO userCreateDTO = new UserCreateDTO(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),"jm1811324@gmail.com",
                "+573154175103","calle 20 #100-80","passworD12","client");
        userController.createUser(userCreateDTO);
        verify(userService, times(1)).createUser(userMapper.fromDTO(userCreateDTO),"client");

    }

    @Test
    public void testCreateAdminUser(){
        UserCreateDTO userCreateDTO = new UserCreateDTO(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"),"jm1811324@gmail.com",
                "+573154175103","calle 20 #100-80","passworD12","client");
        userController.createUser(userCreateDTO);
        verify(userService, times(1)).createUser(userMapper.fromDTO(userCreateDTO),"client");

    }


    @Test
    public void testGetUser(){
        userController.getUser(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
        verify(userService,times(1)).getUser(UUID.fromString("3ecbd684-736f-11ed-a1eb-0242ac120002"));
    }

    @Test
    public void testGetUsers(){
        userController.getUsers();
        verify(userService, times(1)).getUsers();
    }






}
