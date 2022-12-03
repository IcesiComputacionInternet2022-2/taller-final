package co.edu.icesi.store.dto;

import co.edu.icesi.store.model.User;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderDTO {

    private UUID orderId;

    private Double total;

    private String status;

    private User user;
}
