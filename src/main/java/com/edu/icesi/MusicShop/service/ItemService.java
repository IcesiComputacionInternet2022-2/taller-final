package com.edu.icesi.MusicShop.service;

import com.edu.icesi.MusicShop.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    List<Item> getItems();

    Item getItem(@PathVariable UUID itemId);

    Item createItem(@RequestBody Item itemDTO);

}
