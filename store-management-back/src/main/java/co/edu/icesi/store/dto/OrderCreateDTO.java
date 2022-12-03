package co.edu.icesi.store.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDTO {

    private Double total;

    private String status;

    private List<OrderItemCreateDTO> orderItem;

    private UUID userId;
}
