package co.edu.icesi.JCStore.repository;

import co.edu.icesi.JCStore.model.Item;
import org.springframework.data.repository.CrudRepository;


import java.util.UUID;


public interface ItemRepository extends CrudRepository<Item, UUID> {
}
