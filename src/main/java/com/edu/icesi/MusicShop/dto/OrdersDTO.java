package com.edu.icesi.MusicShop.dto;

import com.edu.icesi.MusicShop.model.OrderItem;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class OrdersDTO {

    private UUID id;

    private double total;

    private String status;

    private List<OrderItem> itemDTOList;

}
