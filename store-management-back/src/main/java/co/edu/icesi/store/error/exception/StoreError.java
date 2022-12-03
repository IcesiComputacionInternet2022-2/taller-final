package co.edu.icesi.store.error.exception;

import co.edu.icesi.store.constant.ErrorConstants;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreError {

    private ErrorConstants code;
    private String message;
}