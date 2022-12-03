package co.edu.icesi.store.repository;

import co.edu.icesi.store.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
}
