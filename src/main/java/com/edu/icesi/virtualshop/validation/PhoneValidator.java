package com.edu.icesi.virtualshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;
public class PhoneValidator implements ConstraintValidator<CustomAnnotations.PhoneValidation, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.compile("^\\\\+57\\\\d{10}").matcher(s).find();
    }
}
