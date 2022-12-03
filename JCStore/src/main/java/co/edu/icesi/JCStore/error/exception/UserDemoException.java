package co.edu.icesi.JCStore.error.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class UserDemoException extends RuntimeException{
    private HttpStatus httpStatus;
    private UserDemoError error;
}
