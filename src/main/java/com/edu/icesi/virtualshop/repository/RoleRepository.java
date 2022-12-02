package com.edu.icesi.virtualshop.repository;

import com.edu.icesi.virtualshop.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
