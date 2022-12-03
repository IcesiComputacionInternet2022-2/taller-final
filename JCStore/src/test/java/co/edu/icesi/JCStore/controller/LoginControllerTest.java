package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.dto.LoginDTO;
import co.edu.icesi.JCStore.service.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

    private LoginService loginService;

    private LoginController loginController;

    @BeforeEach
    private void init(){
        loginService = mock(LoginService.class);
        loginController = new LoginController(loginService);
    }

    @Test
    public void loginTest(){
        LoginDTO loginDTO = new LoginDTO();
        loginController.login(loginDTO);
        verify(loginService, times(1)).login(loginDTO);
    }

}
