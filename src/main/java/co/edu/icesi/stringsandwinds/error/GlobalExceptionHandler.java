package co.edu.icesi.stringsandwinds.error;


import co.edu.icesi.stringsandwinds.constant.UserErrorCode;
import co.edu.icesi.stringsandwinds.error.exception.UserError;
import co.edu.icesi.stringsandwinds.error.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.net.BindException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<UserError> handleException(UserException userException){
        return new ResponseEntity<>(userException.getError(), userException.getHttpStatus());
    }

    //O BindException
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<UserError> handleArgumentException(MethodArgumentNotValidException exception){
        BindingResult binding = exception.getBindingResult();

        String wrongField = Objects.requireNonNull(binding.getFieldError()).getField();

        Map<String, Object> body = getErrorCode(wrongField);

        UserErrorCode errorCode = (UserErrorCode) body.get("errorName");
        String errorMsg = body.get("errorMsg").toString();
        HttpStatus errorStatus = HttpStatus.BAD_REQUEST;

        UserError userError = new UserError(errorCode, errorMsg);
        return new ResponseEntity<>(userError, errorStatus);
    }

    private Map<String, Object> getErrorCode(String wrongField) {
        Map<String, Object> errorInfo = new HashMap<>();

        UserErrorCode errorName = UserErrorCode.CODE_00;
        String errorMsg = UserErrorCode.CODE_00.getMessage();

        switch (wrongField){
            case "password":
                errorName = UserErrorCode.CODE_01;
                errorMsg = UserErrorCode.CODE_01.getMessage();
                break;

            case "email":
                errorName = UserErrorCode.CODE_02;
                errorMsg = UserErrorCode.CODE_02.getMessage();
                break;

            case "phone":
                errorName = UserErrorCode.CODE_03;
                errorMsg = UserErrorCode.CODE_03.getMessage();
                break;

            case "firstName":
                errorName = UserErrorCode.CODE_04;
                errorMsg = UserErrorCode.CODE_04.getMessage();
                break;

            case "lastName":
                errorName = UserErrorCode.CODE_05;
                errorMsg = UserErrorCode.CODE_05.getMessage();
                break;
        }
        errorInfo.put("errorName", errorName);
        errorInfo.put("errorMsg", errorMsg);

        return errorInfo;
    }


}