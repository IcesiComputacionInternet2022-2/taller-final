package com.edu.icesi.MusicShop.controller;

import com.edu.icesi.MusicShop.api.OrderAPI;
import com.edu.icesi.MusicShop.dto.OrderDTO;
import com.edu.icesi.MusicShop.dto.OrdersDTO;
import com.edu.icesi.MusicShop.mapper.OrderMapper;
import com.edu.icesi.MusicShop.model.Order;
import com.edu.icesi.MusicShop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class OrderController implements OrderAPI {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    @Override
    public List<OrdersDTO> orders() {
        return orderService.orders();
    }

    @Override
    public void createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.generateId();
        order.setStatus("Created");
        if(order.getId() != null) {
            orderService.createOrder(order, orderMapper.fromItemList(orderDTO.getOrderItemList()));
        }
    }

}
