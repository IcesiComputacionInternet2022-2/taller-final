package co.edu.icesi.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private UUID itemId;

    private String itemName;

    private String itemDescription;

    private Double price;
}
