package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.api.OrderAPI;
import co.edu.icesi.JCStore.dto.OrderDTO;
import co.edu.icesi.JCStore.mapper.OrderMapper;
import co.edu.icesi.JCStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class OrderController implements OrderAPI {

    public final OrderService orderService;
    public final OrderMapper orderMapper;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return orderMapper.fromOrder(orderService.createOrder(orderMapper.fromDTO(orderDTO)));
    }

    @Override
    public List<OrderDTO> getOrders() {
        return orderService.getOrders().stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderDTO(UUID orderId) {
        return orderMapper.fromOrder(orderService.getOrder(orderId));
    }

    @Override
    public OrderDTO updateOrderStatus(UUID orderId, OrderDTO orderDTO) {
        return orderMapper.fromOrder(orderService.updateOrderStatus(orderId, orderMapper.fromDTO(orderDTO)));
    }

    @Override
    public List<OrderDTO> getOrdersMadeByUser(UUID userId) {
        return orderService.getOrdersMadeByUser(userId).stream().map(orderMapper::fromOrder).collect(Collectors.toList());
    }

    @Override
    public OrderDTO cancelOrder(UUID orderId) {
        return orderMapper.fromOrder(orderService.cancelOrder(orderId));
    }
}
