package com.edu.icesi.MusicShop.service.impl;

import com.edu.icesi.MusicShop.dto.OrdersDTO;
import com.edu.icesi.MusicShop.model.Item;
import com.edu.icesi.MusicShop.model.Order;
import com.edu.icesi.MusicShop.model.OrderItem;
import com.edu.icesi.MusicShop.repository.ItemRepository;
import com.edu.icesi.MusicShop.repository.OrderItemRepository;
import com.edu.icesi.MusicShop.repository.OrderRepository;
import com.edu.icesi.MusicShop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@Primary
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepository;

    public final OrderItemRepository orderItemRepository;

    public final ItemRepository itemRepository;

    @Override
    public List<OrdersDTO> orders() {
        List<OrdersDTO> ordersDTOList = new ArrayList<>();
        for(Order o: orderRepository.findAll()) {
            OrdersDTO oDTO = new OrdersDTO();
            oDTO.setId(o.getId());
            oDTO.setStatus(o.getStatus());
            oDTO.setTotal(o.getTotal());
            oDTO.setItemDTOList(StreamSupport.stream(orderItemRepository.findAll().spliterator(), false).filter(i -> i.getOrderId().equals(o.getId())).collect(Collectors.toList()));
            ordersDTOList.add(oDTO);
        }
        return ordersDTOList;
    }

    @Override
    public void createOrder(Order order, List<OrderItem> orderItemList) {
        orderRepository.save(order);
        double total = 0;
        for(OrderItem o : orderItemList) {
            o.generateId();
            o.setOrderId(order.getId());
            System.out.println(o);
            orderItemRepository.save(o);
            Item currentItem = itemRepository.findById(o.getItemId()).orElse(null);
            if(currentItem != null)
                total += currentItem.getPrice();
        }
        order.setTotal(total);
        orderRepository.save(order);
    }
}
