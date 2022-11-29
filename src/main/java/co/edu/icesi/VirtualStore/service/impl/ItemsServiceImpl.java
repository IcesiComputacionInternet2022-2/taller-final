package co.edu.icesi.VirtualStore.service.impl;

import co.edu.icesi.VirtualStore.constant.ItemErrorCode;
import co.edu.icesi.VirtualStore.model.Item;
import co.edu.icesi.VirtualStore.repository.ItemsRepository;
import co.edu.icesi.VirtualStore.service.ItemsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Service
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;

    @Override
    public List<Item> getItems() {
        return StreamSupport.stream(itemsRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    @Override
    public Item getItem(UUID itemId) {
        return itemsRepository.findById(itemId).orElse(null);
    }

    @Override
    public Item addItem(Item item) {
        validateItemExists(item.getName());
        return itemsRepository.save(item);
    }

    private void validateItemExists(String itemName) {
        getItems().forEach(item -> {
            if (item.getName().equals(itemName))
                throw new RuntimeException(ItemErrorCode.CODE_01.getMessage());
        });
    }
}