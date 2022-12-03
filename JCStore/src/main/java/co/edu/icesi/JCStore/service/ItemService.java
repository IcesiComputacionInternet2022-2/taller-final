package co.edu.icesi.JCStore.service;

import co.edu.icesi.JCStore.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ItemService {

    public Item createItem(@RequestBody Item item);
    public List<Item> getItems();
    public Item getItem(@PathVariable UUID itemId);
    public Item updateItem(@PathVariable UUID itemId, @RequestBody Item item);

}
