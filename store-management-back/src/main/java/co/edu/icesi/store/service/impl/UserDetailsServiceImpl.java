package co.edu.icesi.store.service.impl;

import co.edu.icesi.store.model.User;
import co.edu.icesi.store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username).orElseThrow();
        System.out.println("mmmmm");

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder().username(username).password(user.getPassword()).roles(user.getRole().getRoleName()).build();
        return userDetails;
    }
}