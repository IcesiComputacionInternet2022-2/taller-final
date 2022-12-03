package co.edu.icesi.store.repository;

import co.edu.icesi.store.model.Permission;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PermissionRepository extends CrudRepository<Permission, UUID> {
}