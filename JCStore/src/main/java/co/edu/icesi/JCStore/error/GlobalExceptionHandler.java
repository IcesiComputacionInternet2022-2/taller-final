package co.edu.icesi.JCStore.error;

import co.edu.icesi.JCStore.error.exception.UserDemoError;
import co.edu.icesi.JCStore.error.exception.UserDemoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserDemoError> handlerException(UserDemoException userDemoException){
        return new ResponseEntity<>(userDemoException.getError(),userDemoException.getHttpStatus());
    }

}
