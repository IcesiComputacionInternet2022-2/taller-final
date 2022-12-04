package icesi.VirtualStore.controllerUnitTest;

import icesi.VirtualStore.controller.LoginController;
import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.error.exception.VirtualStoreException;
import icesi.VirtualStore.service.LoginService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTest {
    /*
     * items to test
     * Login Method
     */

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;


    @Test
    public void testEmailLogin(){
        LoginDTO loginDTOA = new LoginDTO("jm1811324@gmail.com", "M00n_W4lk3r");

        loginController.login(loginDTOA);
        verify(loginService, times(1)).loginByEmail(loginDTOA);
    }

    @Test
    public void  testPhoneLogin(){
        LoginDTO loginDTOB = new LoginDTO("+573154175103", "M00n_W4lk3r");

        loginController.login(loginDTOB);
        verify(loginService,times(1)).loginByPhoneNumber(loginDTOB);

    }

    @Test
    public void testWrongLogin(){
        LoginDTO loginDTOC = new LoginDTO("abcdeslkaslkjdf", "M00n_W4lk3r");

        Assertions.assertThrows(VirtualStoreException.class, ()->{
            loginController.login(loginDTOC);
        });
    }


}
