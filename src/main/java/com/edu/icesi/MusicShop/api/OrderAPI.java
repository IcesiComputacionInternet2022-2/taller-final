package com.edu.icesi.MusicShop.api;

import com.edu.icesi.MusicShop.dto.OrderDTO;
import com.edu.icesi.MusicShop.dto.OrdersDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/rest/order")
@CrossOrigin(origins = "http://localhost:3000/")
public interface OrderAPI {

    @GetMapping
    List<OrdersDTO> orders();

    @PostMapping
    void createOrder(@RequestBody OrderDTO orderDTO);

}
