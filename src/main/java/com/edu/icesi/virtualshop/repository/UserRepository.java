package com.edu.icesi.virtualshop.repository;

import com.edu.icesi.virtualshop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
}
