package co.edu.icesi.JCStore.repository;

import co.edu.icesi.JCStore.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderItemsRepository extends CrudRepository<OrderItem, UUID> {

    @Query(value = "SELECT * FROM ORDER_ITEM WHERE ORDER_ITEM.order_id = ?1", nativeQuery = true)
    Optional<List<OrderItem>> findOrderItems(UUID orderId);

}
