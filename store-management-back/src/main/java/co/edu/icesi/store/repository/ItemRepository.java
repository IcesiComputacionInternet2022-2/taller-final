package co.edu.icesi.store.repository;

import co.edu.icesi.store.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
}
