package com.edu.icesi.virtualshop.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class VirtualShopException extends RuntimeException {
    private HttpStatus httpStatus;
    private VirtualShopError error;
}
