package com.edu.icesi.virtualshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<CustomAnnotations.EmailValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.matches("\\w+@icesi.edu.co$") || s.matches("\\w+@gmail.com$") || s.matches("\\w+@hotmail.com$") || s.matches("\\w+@outlook.com$") ){
            return true;
        }
        return false;
    }
}
