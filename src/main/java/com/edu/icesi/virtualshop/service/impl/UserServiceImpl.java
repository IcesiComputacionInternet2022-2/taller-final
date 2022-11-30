package com.edu.icesi.virtualshop.service.impl;

import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.edu.icesi.virtualshop.error.exception.VirtualShopException;
import com.edu.icesi.virtualshop.model.User;
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

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;

    @Override
    public User getUser(UUID userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User createUser(User userDTO) {
        if(!isRepeated(userDTO.getEmail(),userDTO.getPhoneNumber())){
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
            if (x.getPhoneNumber().equals(number) || x.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
}

