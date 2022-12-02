package com.edu.icesi.MusicShop.repository;

import com.edu.icesi.MusicShop.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<Order, UUID> {
}
