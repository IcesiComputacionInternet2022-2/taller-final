package co.edu.icesi.JCStore.repository;

import co.edu.icesi.JCStore.model.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
}
