package co.edu.icesi.JCStore.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private UUID orderId;

    @NotNull
    private double total;

    @NotNull
    private String status;

    private List<OrderItemDTO> orderItems;

    private UUID userId;
}
