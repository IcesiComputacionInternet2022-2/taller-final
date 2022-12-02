package com.edu.icesi.virtualshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private UUID itemId;
    private String name;
    private String description;
    private double price;
}
