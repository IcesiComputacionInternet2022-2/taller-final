package co.edu.icesi.store.repository;

import co.edu.icesi.store.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}