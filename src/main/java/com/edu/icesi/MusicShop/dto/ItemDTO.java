package com.edu.icesi.MusicShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

    @NotNull(message = "El id no puede estar vacío")
    private UUID id;

    @NotNull(message = "El nombre del item no puede estar vacío")
    @NotBlank(message = "El nombre del item no puede estar en blanco")
    private String name;

    @NotNull(message = "La descripción del item no puede estar vacía")
    @NotBlank(message = "La descripción del item no puede estar en blanco")
    private String description;

    @NotNull
    @Positive
    private double price;

}
