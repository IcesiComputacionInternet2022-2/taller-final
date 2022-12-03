package co.edu.icesi.store.service.impl;

import co.edu.icesi.store.dto.ItemDTO;
import co.edu.icesi.store.dto.OrderItemCreateDTO;
import co.edu.icesi.store.model.Item;
import co.edu.icesi.store.model.Order;
import co.edu.icesi.store.model.OrderItem;
import co.edu.icesi.store.repository.ItemRepository;
import co.edu.icesi.store.repository.OrderItemRepository;
import co.edu.icesi.store.repository.OrderRepository;
import co.edu.icesi.store.repository.UserRepository;
import co.edu.icesi.store.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService {

    private ItemRepository itemRepository;
    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    @Override
    public Item item(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Order order(Order order, UUID userId, List<OrderItemCreateDTO> listItems) {
        List<OrderItem> orderItemList = new ArrayList<>();
        listItems.forEach(orderItemDTO -> {
            Item item = itemRepository.findById(orderItemDTO.getItem()).orElseThrow();
            OrderItem orderItem = OrderItem.builder().item(item).quantity(orderItemDTO.getQuantity()).build();
            orderItemRepository.save(orderItem);
            orderItemList.add(orderItem);
        });
        order.setUser(userRepository.findById(userId).orElseThrow());
        order.setOrderItems(orderItemList);
        return orderRepository.save(order);
    }

    @Override
    public List<Item> getItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }
}
