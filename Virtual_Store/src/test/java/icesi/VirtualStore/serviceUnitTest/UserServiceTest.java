package icesi.VirtualStore.serviceUnitTest;

import icesi.VirtualStore.model.Permission;
import icesi.VirtualStore.model.Role;
import icesi.VirtualStore.model.User;
import icesi.VirtualStore.repository.PermissionRepository;
import icesi.VirtualStore.repository.RoleRepository;
import icesi.VirtualStore.repository.UserRepository;
import icesi.VirtualStore.service.UserService;
import icesi.VirtualStore.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PermissionRepository permissionRepository;

    private UserService userService;

    private User user;

    private Role role;

    private List<Permission> permissions;

    @BeforeEach
    public void init(){
        permissions = new ArrayList<>();

        role = new Role(UUID.fromString("d0f350b6-7381-11ed-a1eb-0242ac120002"),"client","description",permissions);

        user = new User(UUID.fromString("d0f350b6-7381-11ed-a1eb-0242ac120002"),"correo@exemplo.com","+573004789564","Calle 100 #3-45","Pass1234",role);
        userService = new UserServiceImpl(userRepository,roleRepository,permissionRepository);
    }

    @Test
    public void testGetUser(){
        when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        userService.getUser(user.getUserId());
        verify(userRepository,times(1)).findById(user.getUserId());
    }

    @Test
    public void testGetUsers(){
        userService.getUsers();
        verify(userRepository,times(1)).findAll();
    }

    @Test
    public void testCreateRightUser(){
        when(roleRepository.findByName(role.getName())).thenReturn(Optional.of(role));
        when(userRepository.existsByEmailOrPhoneNumber(user.getEmail(),user.getPhoneNumber())).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);
        userService.createUser(user,role.getName());
        verify(roleRepository,times(1)).findByName(role.getName());
        verify(userRepository,times(1)).existsByEmailOrPhoneNumber(user.getEmail(),user.getPhoneNumber());
        verify(userRepository,times(1)).save(user);
    }



}
