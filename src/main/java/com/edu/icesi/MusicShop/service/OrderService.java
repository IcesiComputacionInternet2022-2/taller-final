package com.edu.icesi.MusicShop.service;

import com.edu.icesi.MusicShop.dto.OrdersDTO;
import com.edu.icesi.MusicShop.model.Order;
import com.edu.icesi.MusicShop.model.OrderItem;

import java.util.List;

public interface OrderService {

    List<OrdersDTO> orders();

    void createOrder(Order order, List<OrderItem> orderItemList);

}
