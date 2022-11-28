package com.edu.icesi.virtualshop.validation;

import com.edu.icesi.virtualshop.dto.UserCreateDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class EmailAndPasswordValidator implements ConstraintValidator<CustomAnnotations.EmailAndPasswordValidation, UserCreateDTO> {

    @Override
    public boolean isValid(UserCreateDTO userCreateDTO, ConstraintValidatorContext constraintValidatorContext) {
        if (!(userCreateDTO instanceof UserCreateDTO)) {
            throw new IllegalArgumentException("This annotation only applies to UserCreateDTO objects");
        }
        return true;

    }
}
