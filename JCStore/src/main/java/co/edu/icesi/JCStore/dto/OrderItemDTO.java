package co.edu.icesi.JCStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {

    private UUID orderItemId;

    private int quantity;

    //private OrderDTO order;

    private ItemDTO item;
}
