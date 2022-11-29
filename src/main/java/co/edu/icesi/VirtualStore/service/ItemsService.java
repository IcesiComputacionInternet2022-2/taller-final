package co.edu.icesi.VirtualStore.service;

import co.edu.icesi.VirtualStore.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ItemsService {

    List<Item> getItems();

    Item getItem(@PathVariable UUID itemId);

    Item addItem(@RequestBody Item item);
}