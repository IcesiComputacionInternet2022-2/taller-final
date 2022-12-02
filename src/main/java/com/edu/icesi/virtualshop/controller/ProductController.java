package com.edu.icesi.virtualshop.controller;

import com.edu.icesi.virtualshop.api.ProductAPI;
import com.edu.icesi.virtualshop.dto.ItemDTO;
import com.edu.icesi.virtualshop.dto.UserCreateDTO;
import com.edu.icesi.virtualshop.dto.UserDTO;
import com.edu.icesi.virtualshop.mapper.ItemMapper;
import com.edu.icesi.virtualshop.mapper.UserMapper;
import com.edu.icesi.virtualshop.service.ProductService;
import com.edu.icesi.virtualshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ProductController implements ProductAPI {
    public final ProductService productService;
    public final ItemMapper itemMapper;

    @Override
    public ItemDTO getProduct(UUID productId) {
        return itemMapper.fromItem(productService.getProduct(productId));
    }

    @Override
    public ItemDTO createProduct(@Valid ItemDTO itemDTO) {
        return itemMapper.fromItem(productService.createProduct(itemMapper.fromDTO(itemDTO)));
    }

    @Override
    public List<ItemDTO> getProducts() {
        return productService.getProducts().stream().map(itemMapper::fromItem).collect(Collectors.toList());
    }
}
