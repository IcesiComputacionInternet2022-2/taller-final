package com.edu.icesi.virtualshop.error.exception;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VirtualShopError {
    private String code;
    private String message;
}