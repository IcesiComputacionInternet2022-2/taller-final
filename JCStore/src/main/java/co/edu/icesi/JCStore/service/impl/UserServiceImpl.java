package co.edu.icesi.JCStore.service.impl;

import co.edu.icesi.JCStore.constants.CodesError;
import co.edu.icesi.JCStore.error.exception.UserDemoError;
import co.edu.icesi.JCStore.error.exception.UserDemoException;
import co.edu.icesi.JCStore.model.Role;
import co.edu.icesi.JCStore.model.User;
import co.edu.icesi.JCStore.repository.RoleRepository;
import co.edu.icesi.JCStore.repository.UserRepository;
import co.edu.icesi.JCStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    @Override
    public User createUser(User user, UUID roleId) {
        verifySingleEmail(user.getEmail());
        verifySinglePhone(user.getPhone());
        Role role = roleRepository.findById(roleId).orElseThrow();
        user.setRole(role);

        return userRepository.save(user);
    }

    private void verifySingleEmail(String email) {
        if (userRepository.findUserByEmail(email).isPresent()) {
            throw new UserDemoException(HttpStatus.BAD_REQUEST,
                    new UserDemoError(CodesError.CODE_02.getCode(), CodesError.CODE_02.getMessage()));
        }
    }

    private void verifySinglePhone(String phone) {
        if (userRepository.findUserByPhone(phone).isPresent()) {
            throw new UserDemoException(HttpStatus.BAD_REQUEST,
                    new UserDemoError(CodesError.CODE_03.getCode(), CodesError.CODE_03.getMessage()));
        }
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }
}
