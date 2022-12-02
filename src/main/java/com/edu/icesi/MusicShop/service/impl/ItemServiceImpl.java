package com.edu.icesi.MusicShop.service.impl;

import com.edu.icesi.MusicShop.model.Item;
import com.edu.icesi.MusicShop.repository.ItemRepository;
import com.edu.icesi.MusicShop.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
@Primary
public class ItemServiceImpl implements ItemService {

    public final ItemRepository itemRepository;

    @Override
    public List<Item> getItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Item getItem(UUID itemId) {
        return null;
    }

    @Override
    public Item createItem(Item itemDTO) {
        return itemRepository.save(itemDTO);
    }

}
