package co.edu.icesi.JCStore.controller;

import co.edu.icesi.JCStore.api.ItemAPI;
import co.edu.icesi.JCStore.dto.ItemDTO;
import co.edu.icesi.JCStore.mapper.ItemMapper;
import co.edu.icesi.JCStore.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor

public class ItemController implements ItemAPI {

    public final ItemService itemService;

    public final ItemMapper itemMapper;



    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        return itemMapper.fromItem(itemService.createItem(itemMapper.fromDTO(itemDTO)));
    }

    @Override
    public List<ItemDTO> getItems() {
        return itemService.getItems().stream().map(itemMapper::fromItem).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItem(UUID itemId) {
        return itemMapper.fromItem(itemService.getItem(itemId));
    }

    @Override
    public ItemDTO updateItem(UUID itemId, ItemDTO itemDTO) {
        return itemMapper.fromItem(itemService.updateItem(itemId, itemMapper.fromDTO(itemDTO)));
    }
}
