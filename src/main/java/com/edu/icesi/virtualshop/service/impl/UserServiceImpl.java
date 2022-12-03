package com.edu.icesi.virtualshop.service.impl;

import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.edu.icesi.virtualshop.error.exception.VirtualShopException;
import com.edu.icesi.virtualshop.model.Role;
import com.edu.icesi.virtualshop.model.User;
import com.edu.icesi.virtualshop.repository.RoleRepository;
import com.edu.icesi.virtualshop.repository.UserRepository;
import com.edu.icesi.virtualshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.edu.icesi.virtualshop.constants.VirtualShopErrorCode.CODE_003;
import static com.edu.icesi.virtualshop.constants.VirtualShopErrorCode.CODE_004;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final RoleRepository roleRepository;

    private final static UUID userRoleId = UUID.fromString("78550f06-9fc7-4b65-a81c-04fc4f7a6e30");

    @Override
    public User getUser(UUID userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){
            return user;
        }
        throw new VirtualShopException(HttpStatus.BAD_REQUEST, new VirtualShopError(CODE_004.toString(),CODE_004.getMessage()));
    }

    @Override
    public User createUser(User userDTO) {
        if(!isRepeated(userDTO.getEmail(),userDTO.getPhoneNumber())){
            Role role = roleRepository.findById(userRoleId).orElseThrow();
            userDTO.setRole(role);
            return userRepository.save(userDTO);
        }
        throw new VirtualShopException(HttpStatus.BAD_REQUEST, new VirtualShopError(CODE_003.toString(), CODE_003.getMessage()));
    }

    @Override
    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    private boolean isRepeated(String email,String number){
        List<User> users = getUsers();
        for (User x : users){
            if(x.getPhoneNumber()!=null){
                if (x.getPhoneNumber().equals(number)){
                    return true;
                }
            }
            if(x.getEmail() != null){
                if(x.getEmail().equals(email)){
                    return true;
                }
            }

        }
        return false;
    }
}

