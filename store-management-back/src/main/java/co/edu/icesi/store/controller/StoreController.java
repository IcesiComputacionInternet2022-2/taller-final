package co.edu.icesi.store.controller;

import co.edu.icesi.store.api.StoreAPI;
import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.dto.OrderCreateDTO;
import co.edu.icesi.store.dto.OrderDTO;
import co.edu.icesi.store.mapper.ItemMapper;
import co.edu.icesi.store.mapper.OrderMapper;
import co.edu.icesi.store.model.Item;
import co.edu.icesi.store.model.OrderItem;
import co.edu.icesi.store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class StoreController implements StoreAPI {

    private StoreService storeService;
    private ItemMapper itemMapper;
    private OrderMapper orderMapper;

    @Override
    public ItemDTO item(Item item) {
        return itemMapper.fromItem(storeService.item(item));
    }

    @Override
    public List<ItemDTO> item() {
        return storeService.getItems().stream().map(itemMapper::fromItem).collect(Collectors.toList());
    }

    @Override
    public OrderDTO order(OrderCreateDTO order) {
        return orderMapper.fromOrder(storeService.order(orderMapper.fromDTO(order), order.getUserId(), order.getOrderItem()));
    }
}
