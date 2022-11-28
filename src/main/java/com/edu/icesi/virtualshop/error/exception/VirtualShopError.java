package com.edu.icesi.virtualshop.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class VirtualShopError {
    private String code;
    private String message;
}