package co.edu.icesi.VirtualStore.repository;

import co.edu.icesi.VirtualStore.model.BasketItem;
import co.edu.icesi.VirtualStore.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BasketItemRepository extends CrudRepository<BasketItem, UUID> {

    @Query(value = "SELECT * FROM basket_items WHERE basket_items.basket_id = #{#basket_id}", nativeQuery = true)
    List<BasketItem> getBasketItems(UUID basketId);
}
