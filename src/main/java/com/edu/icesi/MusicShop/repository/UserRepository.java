package com.edu.icesi.MusicShop.repository;

import com.edu.icesi.MusicShop.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query(value = "SELECT u FROM USER WHERE u.email = ?1 ", nativeQuery = true)
    Optional<User> findUserByEmail(String email);

}
