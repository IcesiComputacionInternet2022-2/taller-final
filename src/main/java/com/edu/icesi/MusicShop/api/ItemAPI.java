package com.edu.icesi.MusicShop.api;

import com.edu.icesi.MusicShop.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/rest/item")
@CrossOrigin(origins = "http://localhost:3000/")
public interface ItemAPI {

    @GetMapping
    List<ItemDTO> getItems();

    @GetMapping("/{itemId}")
    ItemDTO getItem(@PathVariable UUID itemId);

    @PostMapping
    ItemDTO createItem(@RequestBody ItemDTO itemDTO);

}
