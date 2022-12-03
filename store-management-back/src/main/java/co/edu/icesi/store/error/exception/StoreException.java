package co.edu.icesi.store.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class StoreException extends RuntimeException {

    private HttpStatus httpStatus;
    private StoreError error;
}