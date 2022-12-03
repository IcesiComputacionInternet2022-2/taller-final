package co.edu.icesi.JCStore.security;

import co.edu.icesi.JCStore.repository.RoleRepository;
import co.edu.icesi.JCStore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class PermissionConfig{

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Bean
    public void searchPermission(){

    }

}
