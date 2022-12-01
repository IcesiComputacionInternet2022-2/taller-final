package com.edu.icesi.virtualshop.validation;

import com.edu.icesi.virtualshop.dto.UserCreateDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class EmailAndPhoneValidator implements ConstraintValidator<CustomAnnotations.EmailAndPhoneValidation, UserCreateDTO> {

    @Override
    public boolean isValid(UserCreateDTO userCreateDTO, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("existo");
        if (!(userCreateDTO instanceof UserCreateDTO)) {
            throw new IllegalArgumentException("This annotation only applies to UserCreateDTO objects");
        }
        if(userCreateDTO.getPhone() == null && userCreateDTO.getEmail() == null){
            return false;
        }
        return true;
    }
}
