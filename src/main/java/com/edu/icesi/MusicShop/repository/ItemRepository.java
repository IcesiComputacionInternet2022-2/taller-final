package com.edu.icesi.MusicShop.repository;

import com.edu.icesi.MusicShop.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ItemRepository extends CrudRepository<Item, UUID> {
}
