package com.edu.icesi.virtualshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<CustomAnnotations.PasswordValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.compile("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W)").matcher(s).find();
    }
}

