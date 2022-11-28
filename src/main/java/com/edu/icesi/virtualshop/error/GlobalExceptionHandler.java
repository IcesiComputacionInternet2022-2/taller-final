package com.edu.icesi.virtualshop.error;

import com.edu.icesi.virtualshop.constants.VirtualShopErrorCode;
import com.edu.icesi.virtualshop.error.exception.VirtualShopError;
import com.edu.icesi.virtualshop.error.exception.VirtualShopException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.BindException;
import java.util.Map;
import java.util.Objects;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<VirtualShopError> handleException(VirtualShopException virtualShopException){
        return new ResponseEntity<>(virtualShopException.getError(), virtualShopException.getHttpStatus());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<VirtualShopError> handleArgumentException(MethodArgumentNotValidException exception){
        BindingResult binding = exception.getBindingResult();

        String wrongField = Objects.requireNonNull(binding.getFieldError()).getField();

        VirtualShopErrorCode errorCode = getErrorCode(wrongField);


        HttpStatus errorStatus = HttpStatus.BAD_REQUEST;

        VirtualShopError userError = new VirtualShopError(errorCode.toString(), errorCode.getMessage());
        return new ResponseEntity<>(userError, errorStatus);
    }

    private VirtualShopErrorCode getErrorCode(String wrongField){
        switch (wrongField){
            case "password":
                return VirtualShopErrorCode.CODE_001;
            case "email":
                return VirtualShopErrorCode.CODE_006;
            case "phone":
                return VirtualShopErrorCode.CODE_007;
        }
        return null;
    }

}
