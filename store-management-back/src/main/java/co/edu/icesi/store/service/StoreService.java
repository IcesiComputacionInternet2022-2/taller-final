package co.edu.icesi.store.service;

import co.edu.icesi.store.dto.OrderItemCreateDTO;
import co.edu.icesi.store.model.Item;
import co.edu.icesi.store.model.Order;
import co.edu.icesi.store.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface StoreService {

    Item item(@RequestBody Item item);

    Order order(@RequestBody Order order, UUID userId, List<OrderItemCreateDTO> listItems);

    List<Item> getItems();

}
