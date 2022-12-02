package co.edu.icesi.VirtualStore.service;

import co.edu.icesi.VirtualStore.dto.LoginDTO;
import co.edu.icesi.VirtualStore.model.User;
import co.edu.icesi.VirtualStore.repository.UserRepository;
import co.edu.icesi.VirtualStore.service.impl.LoginServiceImpl;
import org.aspectj.lang.annotation.Before;
import org.h2.engine.UserBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.mock;

public class LoginServiceTest {

    private LoginService loginService;

    private UserRepository userRepository;

    private UUID testUserUUID = UUID.fromString("1887fcda-c227-400b-ad7c-541802a92d74");

    private User testUser;

    private LoginDTO testLoginDTO;

    @BeforeEach
    void init(){
        userRepository = mock(UserRepository.class);

        loginService = new LoginServiceImpl(userRepository);

        testUser = new User(testUserUUID,"test@icesi.edu.co","Qwerty123#","C14","+573161234567",null);

        testLoginDTO = new LoginDTO();
    }

    @Test
    void testLoginPhone(){



    }

    @Test
    void testLoginPhoneWrongPassword(){



    }

    @Test
    void testLoginEmail(){

    }

    @Test
    void testLoginEmailWrongPassword(){

    }




}
