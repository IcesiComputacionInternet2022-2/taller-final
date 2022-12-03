package co.edu.icesi.JCStore.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    private UUID itemId;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private double price;

    private String url;
}
