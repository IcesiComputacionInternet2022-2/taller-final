package com.edu.icesi.virtualshop.Service;

import com.edu.icesi.virtualshop.model.User;
import com.edu.icesi.virtualshop.repository.UserRepository;
import com.edu.icesi.virtualshop.service.UserService;
import com.edu.icesi.virtualshop.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;
    private UserRepository userRepository;
    private User user;
    private UUID uuid;

    @BeforeEach
    private void init() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    private void setupScene1() {
        uuid = UUID.randomUUID();
        String email = "angrybirdsgall3o@icesi.edu.co";
        String phoneNumber = "+573162970888";
        String password = "aa@aaa1A";
        String address = "Carrera 5 No 20-14 Conjunto residencial las Acacias, casa 33";

        user = new User(uuid, email, phoneNumber,password,address);
    }

    @Test
    public void testCreateUser() {
        setupScene1();
        when(userRepository.save(any())).thenReturn(new User());
        User createdUser = userService.createUser(user);
        assertNotNull(createdUser); //User is not null
        verify(userRepository, times(1)).save(any()); //Save is being called
    }

    @Test
    public void testGetUser() {
        setupScene1();
        userService.createUser(user);
        User obtainedUser = userService.getUser(uuid);
        verify(userRepository, times(1)).findById(any()); //Save is being called
    }

    @Test
    public void testGetUsers() {
        //First User
        setupScene1();
        //Second User
        UUID uuid2 = UUID.randomUUID();
        String email2 = "prueba@icesi.edu.co";
        String phoneNumber2 = "+573207828580";
        String password2 = "Abc123@";
        String address2 = "Calle 5ta 29";

        //Create User
        User user2 = new User(uuid2, email2, phoneNumber2,password2,address2);
        userService.createUser(user);
        userService.createUser(user2);
        userService.getUsers();
        verify(userRepository, times(3)).findAll(); //It's called 3 times because createUser calls getUsers
    }

    @Test
    public void testNonRepeatedEmailOrNumber() {
        setupScene1();
        List<User> users = new ArrayList<>();

        //Create User
        when(userRepository.save(any())).thenReturn(user);
        User createdUser = userService.createUser(user);
        users.add(createdUser);
        when(userService.getUsers()).thenReturn(users);
        try {
            userService.createUser(user);
        } catch (Exception e) {
            verify(userRepository, times(1)).save(any());
        }
    }
}
