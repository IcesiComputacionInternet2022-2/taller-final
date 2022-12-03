package co.edu.icesi.JCStore.repository;

import co.edu.icesi.JCStore.model.Order;
import co.edu.icesi.JCStore.model.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {

    @Query(value = "SELECT * FROM ORDERS WHERE ORDERS.user_id = ?1", nativeQuery = true)
    Optional<List<Order>> findUserOrders(UUID userId);

}
