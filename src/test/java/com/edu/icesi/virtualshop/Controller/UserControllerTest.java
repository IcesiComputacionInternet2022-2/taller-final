package com.edu.icesi.virtualshop.Controller;

import com.edu.icesi.virtualshop.controller.UserController;
import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.mapper.UserMapper;
import com.edu.icesi.virtualshop.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserControllerTest {
    private UserController userController;
    private UserService userService;
    private UserMapper userMapper;
    private UserCreateDTO userCreateDTO;
    private UUID uuid;


    @BeforeEach
    private void init(){
        userService = mock(UserService.class);
        userMapper = mock(UserMapper.class);
        userController = new UserController(userService,userMapper);
    }

    private void setupScene1(){
        uuid = UUID.randomUUID();
        String email = "angrybirdsgall3o@icesi.edu.co";
        String phoneNumber = "+573162970888";
        String password = "aa@aaa1A";
        String address = "Carrera 5 No 20-14 Conjunto residencial las Acacias, casa 33";
        userCreateDTO = new UserCreateDTO(uuid,email,phoneNumber,password,address,null);
    }

    @Test
    public void testCreateUsers(){
        setupScene1();
        assertFalse(createGeneratesException());
    }

    @Test
    public void testGetUsers(){
        userController.getUsers();
        verify(userService, times(1)).getUsers();
    }

    @Test
    public void testGetUser(){
        setupScene1();
        userController.getUser(uuid);
        verify(userService,times(1)).getUser(uuid);
    }

    private boolean createGeneratesException(){
        when(userMapper.fromUserWithPassword(any())).thenReturn(userCreateDTO);
        try {
            userController.createUser(userCreateDTO);
        }
        catch (Exception e){
            return true;
        }
        return false;
    }


}
