package co.edu.icesi.store.error;

import co.edu.icesi.store.error.exception.StoreError;
import co.edu.icesi.store.error.exception.StoreException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StoreError> handleException(StoreException userDemoException) {
        return new ResponseEntity<>(userDemoException.getError(), userDemoException.getHttpStatus());
    }
}