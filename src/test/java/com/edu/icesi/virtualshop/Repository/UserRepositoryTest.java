package com.edu.icesi.virtualshop.Repository;

import com.edu.icesi.virtualshop.model.User;
import com.edu.icesi.virtualshop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration()
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenCalledSave_thenCorrectNumberOfUsers() {
        userRepository.save(User.builder().email("asds").phoneNumber("asdsd").password("asfa").address("asf").build());
        List<User> users = (List<User>) userRepository.findAll();

        assertThat(users.size()).isEqualTo(1);
    }

}
