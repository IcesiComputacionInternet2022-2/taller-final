package icesi.VirtualStore.serviceUnitTest;

import icesi.VirtualStore.dto.LoginDTO;
import icesi.VirtualStore.model.Permission;
import icesi.VirtualStore.model.Role;
import icesi.VirtualStore.model.User;
import icesi.VirtualStore.repository.RoleRepository;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.LoginService;
import icesi.VirtualStore.service.impl.LoginServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    private User user;

    private Role role;

    private List<Permission> permissions;

    private LoginService loginService;

    @BeforeEach
    public void init(){
        permissions = new ArrayList<>();
        role = new Role(UUID.fromString("294f4eee-737e-11ed-a1eb-0242ac120002"),"client","description",permissions);
        user = new User(UUID.fromString("294f4eee-737e-11ed-a1eb-0242ac120002"),"correo@ejemplo.com","+573006457895","calle 100 #100-120","Pass1234",role);

        loginService = new LoginServiceImpl(userRepository,roleRepository);
    }


    @Test
    public void testEmailLogin(){
        LoginDTO loginDTO =  new LoginDTO("jm1811324@gmail.com","Pass1234");
        when(userRepository.findByEmail("jm1811324@gmail.com")).thenReturn(Optional.of(user));
        loginService.loginByEmail(loginDTO);
        verify(userRepository,times(1)).findByEmail("jm1811324@gmail.com");
    }

    @Test
    public void testPhoneLogin(){
        LoginDTO loginDTO = new LoginDTO("+573004749865","Pass1234");
        when(userRepository.findByPhoneNumber("+573004749865")).thenReturn(Optional.of(user));
        loginService.loginByPhoneNumber(loginDTO);
        verify(userRepository,times(1)).findByPhoneNumber("+573004749865");
    }

    @Test
    public void testGetPermissionByRoleId(){
        when(roleRepository.findById(role.getRoleId())).thenReturn(Optional.of(role));
        loginService.getPermissionsByRoleId(role.getRoleId());
        verify(roleRepository,times(1)).findById(role.getRoleId());
    }





}
