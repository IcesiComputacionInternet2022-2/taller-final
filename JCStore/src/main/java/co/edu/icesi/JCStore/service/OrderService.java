package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.model.Order;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    public Order createOrder(@PathVariable Order order);

    public List<Order> getOrders();

    public Order getOrder(@PathVariable UUID orderId);

    public Order updateOrderStatus(@PathVariable UUID orderId, @RequestBody Order order);

    public List<Order> getOrdersMadeByUser(@PathVariable UUID userId);

    public Order cancelOrder(@PathVariable UUID orderId);
}
