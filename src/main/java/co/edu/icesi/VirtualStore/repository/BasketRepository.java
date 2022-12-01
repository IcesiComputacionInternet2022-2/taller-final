package co.edu.icesi.VirtualStore.repository;

import co.edu.icesi.VirtualStore.model.Basket;
import co.edu.icesi.VirtualStore.model.BasketItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BasketRepository extends CrudRepository<Basket, UUID> {
    @Query(value = "SELECT * FROM baskets WHERE baskets.user_id = #{#userId}", nativeQuery = true)
    Basket getBasket(UUID userId);
}
