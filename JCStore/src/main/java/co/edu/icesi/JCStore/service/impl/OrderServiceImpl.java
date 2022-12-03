package co.edu.icesi.JCStore.service.impl;

import co.edu.icesi.JCStore.constants.OrderStatus;
import co.edu.icesi.JCStore.model.Item;
import co.edu.icesi.JCStore.model.Order;
import co.edu.icesi.JCStore.model.OrderItem;
import co.edu.icesi.JCStore.repository.ItemRepository;
import co.edu.icesi.JCStore.repository.OrderItemsRepository;
import co.edu.icesi.JCStore.repository.OrderRepository;
import co.edu.icesi.JCStore.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    public final OrderRepository orderRepository;
    public final OrderItemsRepository orderItemsRepository;
    public final ItemRepository itemRepository;

    @Override
    public Order createOrder(Order order) {
        Order savedOrder = orderRepository.save(order); //Save empty order
        saveOrderedItems(savedOrder, order.getOrderItems()); //Save order's items (references an empty order)
        calculateOrdersTotal(savedOrder);
        return orderRepository.save(savedOrder);
    }

    @Override
    public List<Order> getOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Order getOrder(UUID orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public Order updateOrderStatus(UUID orderId, Order order) {
        Order updatedOrder = orderRepository.findById(orderId).orElse(null);
        if(updatedOrder != null){
            updatedOrder.setStatus(order.getStatus());
            orderRepository.save(updatedOrder);
        }
        return updatedOrder;
    }

    @Override
    public List<Order> getOrdersMadeByUser(UUID userId) {
        return orderRepository.findUserOrders(userId).orElse(new ArrayList<>());
    }

    @Override
    public Order cancelOrder(UUID orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if(order != null){
            order.setStatus(OrderStatus.CANCELED);
            return orderRepository.save(order);
        }
        return null;
    }

    private void calculateOrdersTotal(Order order) {
        double total = 0;
        System.out.println(orderItemsRepository.findOrderItems(order.getOrderId()));
        Optional<List<OrderItem>> orderItems = orderItemsRepository.findOrderItems(order.getOrderId());
        if(orderItems.isPresent() && !orderItems.get().isEmpty()){
            for (OrderItem orderItem: orderItems.get()) {
                total += orderItem.getQuantity() * orderItem.getItem().getPrice();
            }
        }
        order.setTotal(total);
    }

    private void saveOrderedItems(Order order, List<OrderItem> orderItems) {
        for (OrderItem orderItem: orderItems) {
            Order referenceOrder = new Order();
            referenceOrder.setOrderId(order.getOrderId());
            orderItem.setOrder(referenceOrder);
            orderItem.setItem(itemRepository.findById(orderItem.getItem().getItemId()).get());
            orderItemsRepository.save(orderItem);
        }
        //System.out.println(StreamSupport.stream(orderItemsRepository.findAll().spliterator(), false).collect(Collectors.toList()));
    }
}
