package com.edu.icesi.MusicShop.repository;

import com.edu.icesi.MusicShop.model.Permission;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PermissionRepository extends CrudRepository<Permission, UUID> {
}
