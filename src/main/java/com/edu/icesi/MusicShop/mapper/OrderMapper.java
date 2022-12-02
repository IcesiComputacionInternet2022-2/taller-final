package com.edu.icesi.MusicShop.mapper;

import com.edu.icesi.MusicShop.dto.OrderDTO;
import com.edu.icesi.MusicShop.dto.OrderItemDTO;
import com.edu.icesi.MusicShop.dto.OrdersDTO;
import com.edu.icesi.MusicShop.model.Order;
import com.edu.icesi.MusicShop.model.OrderItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order fromDTO(OrderDTO orderDTO);

    OrderDTO fromOrder(Order order);

    List<OrderItem> fromItemList(List<OrderItemDTO> orderItemList);

}
