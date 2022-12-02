package com.edu.icesi.MusicShop.repository;

import com.edu.icesi.MusicShop.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderItemRepository extends CrudRepository<OrderItem, UUID> {
}
