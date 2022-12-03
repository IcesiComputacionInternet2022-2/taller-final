package com.edu.icesi.MusicShop.repository;

import com.edu.icesi.MusicShop.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
