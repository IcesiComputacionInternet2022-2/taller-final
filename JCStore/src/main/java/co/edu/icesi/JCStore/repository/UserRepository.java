package co.edu.icesi.JCStore.repository;

import co.edu.icesi.JCStore.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query(value = "SELECT * FROM USERS WHERE email = ?1", nativeQuery = true)
    Optional<User> findUserByEmail(String email);

    @Query(value = "SELECT * FROM USERS WHERE phone = ?1", nativeQuery = true)
    Optional<User> findUserByPhone(String phone);
}
