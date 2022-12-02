package com.edu.icesi.virtualshop.service.impl;

import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.edu.icesi.virtualshop.error.exception.VirtualShopException;
import com.edu.icesi.virtualshop.model.Item;
import com.edu.icesi.virtualshop.model.User;
import com.edu.icesi.virtualshop.repository.ItemRepository;
import com.edu.icesi.virtualshop.repository.UserRepository;
import com.edu.icesi.virtualshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.edu.icesi.virtualshop.constants.VirtualShopErrorCode.*;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {
    public final ItemRepository itemRepository;

    @Override
    public Item getProduct(UUID itemId) {
        Item item = itemRepository.findById(itemId).orElse(null);
        if(item!=null){
            return item;
        }
        throw new VirtualShopException(HttpStatus.BAD_REQUEST, new VirtualShopError(CODE_009.toString(),CODE_009.getMessage()));
    }

    @Override
    public Item createProduct(Item itemDTO) {
        if(!isRepeated(itemDTO.getName())){
            return itemRepository.save(itemDTO);
        }
        throw new VirtualShopException(HttpStatus.BAD_REQUEST, new VirtualShopError(CODE_003.toString(), CODE_003.getMessage()));
    }

    @Override
    public List<Item> getProducts() {
        return StreamSupport.stream(itemRepository.findAll().spliterator(),false).collect(Collectors.toList());
    }

    private boolean isRepeated(String name){
        List<Item> items = getProducts();
        for (Item x : items){
            if(x.getName()!=null){
                if (x.getName().equals(name)){
                    return true;
                }
            }
        }
        return false;
    }
}
