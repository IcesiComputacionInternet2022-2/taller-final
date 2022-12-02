package com.edu.icesi.virtualshop.api;

import com.edu.icesi.virtualshop.dto.ItemDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/products")
public interface ProductAPI {
    @GetMapping("/{itemId}")
    public ItemDTO getProduct(@PathVariable UUID itemId);

    @PostMapping
    public ItemDTO createProduct(@RequestBody ItemDTO itemDTO);

    @GetMapping
    public List<ItemDTO> getProducts();


}
