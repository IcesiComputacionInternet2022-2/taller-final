package com.edu.icesi.virtualshop.service;

import com.edu.icesi.virtualshop.model.Item;
import com.edu.icesi.virtualshop.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public Item getProduct(@PathVariable UUID itemId);

    public Item createProduct(@RequestBody Item itemDTO);

    public List<Item> getProducts();

}
