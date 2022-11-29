package co.edu.icesi.VirtualStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private UUID id;

    private String name;

    private String description;

    @DecimalMin(value = "0", message = "The item price cannot be negative.")
    private double price;
}
