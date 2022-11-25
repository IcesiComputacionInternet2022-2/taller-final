package co.edu.icesi.VirtualStore.repository;

import co.edu.icesi.VirtualStore.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemsRepository extends CrudRepository<Item, UUID> {
}
