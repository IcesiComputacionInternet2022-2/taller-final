package com.edu.icesi.virtualshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
public class PhoneValidator implements ConstraintValidator<CustomAnnotations.PhoneValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s!=null && !s.equals("")){
            return s.matches("^(\\+57)[0-9]{10}");
        }
        return true;
    }
}
