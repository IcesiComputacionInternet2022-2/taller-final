package co.edu.icesi.store.validation;

import co.edu.icesi.store.constant.ErrorConstants;
import co.edu.icesi.store.error.exception.StoreError;
import co.edu.icesi.store.error.exception.StoreException;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<CustomAnnotations.PasswordValidation, String> {
    @Override
    public void initialize(CustomAnnotations.PasswordValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#%])[A-Za-z\\d@$#%]{8,}$").matcher(str).find();
        if (!valid)
            throw new StoreException(HttpStatus.BAD_REQUEST, new StoreError(ErrorConstants.CODE_UD_11, ErrorConstants.CODE_UD_11.getMessage()));
        return true;
    }
}