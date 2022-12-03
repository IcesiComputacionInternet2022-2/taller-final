package co.edu.icesi.JCStore.service.impl;

import co.edu.icesi.JCStore.model.Item;
import co.edu.icesi.JCStore.repository.ItemRepository;
import co.edu.icesi.JCStore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ItemServiceImpl implements ItemService {

    public final ItemRepository itemRepository;

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItems() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Item getItem(UUID itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    @Override
    public Item updateItem(UUID itemId, Item item) {
        Item updatedItem = itemRepository.findById(itemId).orElse(null);
        if(updatedItem != null && item != null){
            updatedItem.setName(item.getName());
            updatedItem.setUrl(item.getUrl());
            updatedItem.setPrice(item.getPrice());
            updatedItem.setDescription(item.getDescription());
        }
        return updatedItem;
    }
}
