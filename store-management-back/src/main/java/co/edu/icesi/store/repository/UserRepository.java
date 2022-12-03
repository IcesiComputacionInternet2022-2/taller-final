package co.edu.icesi.store.repository;

import co.edu.icesi.store.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query(value = "SELECT * FROM users as u WHERE u.email = ?1", nativeQuery = true)
    Optional<User> findUserByEmail(String email);

    @Query(value = "UPDATE users as u set u.user_name = ?2, u.email = ?3, u.address = ?4, u.phoneNumber = ?5, u.role_id = ?6 WHERE u.user_id = ?1 returning *", nativeQuery = true)
    User updateUserById(UUID userId, String userName, String email, String address, String phoneNumber, UUID roleId);
}