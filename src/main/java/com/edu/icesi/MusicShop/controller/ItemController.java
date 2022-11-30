package com.edu.icesi.MusicShop.controller;

import com.edu.icesi.MusicShop.api.ItemAPI;
import com.edu.icesi.MusicShop.dto.ItemDTO;
import com.edu.icesi.MusicShop.mapper.ItemMapper;
import com.edu.icesi.MusicShop.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ItemController implements ItemAPI {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getItems() {
        return itemService.getItems().stream().map(itemMapper::fromItem).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItem(UUID itemId) {
        return null;
    }

    @Override
    public ItemDTO createItem(@Valid ItemDTO itemDTO) {
        return null;
    }

}
